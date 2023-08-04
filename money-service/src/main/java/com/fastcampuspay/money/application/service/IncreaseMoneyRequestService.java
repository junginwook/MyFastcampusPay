package com.fastcampuspay.money.application.service;

import com.fastcampuspay.common.CountDownLatchManager;
import com.fastcampuspay.common.RechargingMoneyTask;
import com.fastcampuspay.common.SubTask;
import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.money.adapter.out.persistence.MemberMoneyJpaEntity;
import com.fastcampuspay.money.adapter.out.persistence.MoneyChangingRequestMapper;
import com.fastcampuspay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.fastcampuspay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.fastcampuspay.money.application.port.out.GetMembershipPort;
import com.fastcampuspay.money.application.port.out.IncreaseMoneyPort;
import com.fastcampuspay.money.application.port.out.MembershipStatus;
import com.fastcampuspay.money.application.port.out.SendRechargingMoneyTaskPort;
import com.fastcampuspay.money.domain.MemberMoney.MembershipId;
import com.fastcampuspay.money.domain.MoneyChangingRequest;
import com.fastcampuspay.money.domain.MoneyChangingRequest.ChangingMoneyAmount;
import com.fastcampuspay.money.domain.MoneyChangingRequest.MoneyChangingStatus;
import com.fastcampuspay.money.domain.MoneyChangingRequest.MoneyChangingType;
import com.fastcampuspay.money.domain.MoneyChangingRequest.TargetMembershipId;
import com.fastcampuspay.money.domain.MoneyChangingRequest.Uuid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.aspectj.bridge.ICommand;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class IncreaseMoneyRequestService implements IncreaseMoneyRequestUseCase {

	private final CountDownLatchManager countDownLatchManager;
	private final SendRechargingMoneyTaskPort sendRechargingMoneyTaskPort;
	private final GetMembershipPort membershipPort;
	private final IncreaseMoneyPort increaseMoneyPort;

	private final MoneyChangingRequestMapper mapper;

	@Override
	public MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command) {

		// 머니 충전, 증액
		// 1. 고객 정보가 정상인지 확인 (멤버)
		membershipPort.getMembership(command.getTargetMembershipId() + "");
		// 2. 고객의 연동된 계좌가 있는지 확인, 고객의 연동된 계좌의 잔액이 충분한지도 확인 (뱅킹)

		// 3. 법인 계좌 상태도 정상인지 확인(뱅킹)
		// 4. 증액을 위한 "기록" 요청 상태로 MoneyChangingRequest를 생성한다. (MoneyChangingRequest)
		// 5. 펌뱅킹을 수행한다. (고객의 연동되 ㄴ계좌 -> 패캠페이 법인 계좌) (뱅킹)
		// 6-1. 결과가 정상적이라면, 성공으로 MoneyChangingRequest 상태값을 변동 후에 리턴
		MemberMoneyJpaEntity memberMoneyJpaEntity = increaseMoneyPort.increaseMoney(
				new MembershipId(command.getTargetMembershipId()),
				command.getAmount()
		);

		if (memberMoneyJpaEntity != null) {
			return mapper.mapToDomainEntity(increaseMoneyPort.createMoneyChangingRequest(
					new TargetMembershipId(command.getTargetMembershipId()),
					new MoneyChangingType(1),
					new ChangingMoneyAmount(command.getAmount()),
					new MoneyChangingStatus(0),
					new Uuid(UUID.randomUUID())
			));
		}

		// 6-2. 결과가 실패라면, 실패라고 MoneyChangingRequest 상태값을 변동 후에 리턴
		return null;
	}

	@Override
	public MembershipStatus increaseMoneyRequestAsync(IncreaseMoneyRequestCommand command) {

		//
		// 1. SubTask, Task
		// subtask validation을 하기위한 Task
		SubTask validMemberTask = SubTask.builder()
				.subTaskName("validMemberTask: " + "맴버십 유효성 검사")
				.membershipID(command.getTargetMembershipId() + "")
				.taskType("membership")
				.status("ready")
				.build();

		// Banking Sub Task
		// Banking Account Validation
		// Amount Money Frimbanking ---> 무조건 ok 받았다고 가정

		SubTask validBankingAccountTask = SubTask.builder()
				.subTaskName("validBankingAccountTask: " + "뱅킹 계좌 유효성 검사")
				.membershipID(command.getTargetMembershipId() + "")
				.taskType("banking")
				.status("ready")
				.build();

		List<SubTask> subTaskList = new ArrayList<>();
		subTaskList.add(validMemberTask);
		subTaskList.add(validBankingAccountTask);

		RechargingMoneyTask task = RechargingMoneyTask.builder()
				.taskID(UUID.randomUUID().toString())
				.taskName("Increase Money Task / 머니 충전 Task")
				.subTaskList(subTaskList)
				.moneyAmount(command.getAmount())
				.membershipID(command.getTargetMembershipId() + "")
				.toBankName("fastcampus")
				.build();

		// 2. Kafka Cluster에 produce
		sendRechargingMoneyTaskPort.sendRechargingMoneyTaskPort(task);
		// 3. wait
		try {
			countDownLatchManager.getCountDownLatch("rechargingMoneyTask").await();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		// 4. task-consumer
		// 등록된 sub-task, status 모두 ok -> task 결과를 produce
		// Task Result Consume
		// Consyme ok, Logic
		return null;
	}


}
