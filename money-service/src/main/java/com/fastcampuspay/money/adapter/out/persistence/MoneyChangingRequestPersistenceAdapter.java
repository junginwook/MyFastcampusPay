package com.fastcampuspay.money.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.money.application.port.out.IncreaseMoneyPort;
import com.fastcampuspay.money.domain.MemberMoney.MembershipId;
import com.fastcampuspay.money.domain.MoneyChangingRequest.ChangingMoneyAmount;
import com.fastcampuspay.money.domain.MoneyChangingRequest.MoneyChangingStatus;
import com.fastcampuspay.money.domain.MoneyChangingRequest.MoneyChangingType;
import com.fastcampuspay.money.domain.MoneyChangingRequest.TargetMembershipId;
import com.fastcampuspay.money.domain.MoneyChangingRequest.Uuid;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MoneyChangingRequestPersistenceAdapter implements IncreaseMoneyPort {

	private final SpringDataMoneyChangingRequestRepository moneyChangingRequestRepository;

	private final SpringDataMemberMoneyRepository memberMoneyRepository;

	@Override
	public MoneyChangingRequestJpaEntity createMoneyChangingRequest(TargetMembershipId targetMembershipId, MoneyChangingType moneyChangingType, ChangingMoneyAmount changingMoneyAmount,
			MoneyChangingStatus moneyChangingStatus, Uuid uuid) {

		return moneyChangingRequestRepository.save(
				new MoneyChangingRequestJpaEntity(
						targetMembershipId.getTargetMembershipId(),
						moneyChangingType.getChangingType(),
						changingMoneyAmount.getChangingMoneyAmount(),
						new Timestamp(System.currentTimeMillis()),
						moneyChangingStatus.getChangingMoneyStatus(),
						UUID.randomUUID()
				)
		);
	}

	@Override
	public MemberMoneyJpaEntity increaseMoney(MembershipId membershipId, int increaseMoneyAmount) {

		Optional<MemberMoneyJpaEntity> entityOptional = memberMoneyRepository.findUserMemberMoney(membershipId.getMembershipId());
		if (entityOptional.isPresent() == false) {
			MemberMoneyJpaEntity memberMoneyJpaEntity = new MemberMoneyJpaEntity(
					membershipId.getMembershipId(),
					increaseMoneyAmount
			);

			return memberMoneyRepository.save(memberMoneyJpaEntity);
		}

		MemberMoneyJpaEntity entity = entityOptional.get();
		entity.setBalance(entity.getBalance() + increaseMoneyAmount);

		return memberMoneyRepository.save(entity);
	}
}
