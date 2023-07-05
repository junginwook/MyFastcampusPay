package com.fastcampuspay.banking.application.service;

import com.fashcampuspay.common.UseCase;
import com.fastcampuspay.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import com.fastcampuspay.banking.adapter.out.external.bank.FirmBankingResult;
import com.fastcampuspay.banking.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.fastcampuspay.banking.adapter.out.persistence.FirmBankingRequestMapper;
import com.fastcampuspay.banking.application.port.in.RequestFirmBankingCommand;
import com.fastcampuspay.banking.application.port.in.RequestFirmBankingUseCase;
import com.fastcampuspay.banking.application.port.out.RequestExternalFirmBankingPort;
import com.fastcampuspay.banking.application.port.out.RequestFirmBankingPort;
import com.fastcampuspay.banking.domain.FirmBankingRequest;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FirmBankingStatus;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FromBankAccountNumber;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FromBankName;
import com.fastcampuspay.banking.domain.FirmBankingRequest.MoneyAmount;
import com.fastcampuspay.banking.domain.FirmBankingRequest.ToBankAccountNumber;
import com.fastcampuspay.banking.domain.FirmBankingRequest.ToBankName;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

	private final FirmBankingRequestMapper mapper;

	private final RequestFirmBankingPort requestFirmBankingPort;

	private final RequestExternalFirmBankingPort requestExternalFirmBankingPort;

	@Override
	public FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command) {

		// a계좌 -> b계좌
		//1. 요청에 대해 먼저 write -> RequestFirmBankingPort
		FirmBankingRequestJpaEntity requestedEntity = requestFirmBankingPort.createFirmBankingRequest(
				new FromBankName(command.getFromBankName()),
				new FromBankAccountNumber(command.getFromBankAccountNumber()),
				new ToBankName(command.getToBankName()),
				new ToBankAccountNumber(command.getToBankAccountNumber()),
				new MoneyAmount(command.getMoneyAmount()),
				new FirmBankingStatus(0)
		);

		//2. 외부 은행에 펌뱅킹 요청 -> RequestExternalFirmBankingPort
		FirmBankingResult result = requestExternalFirmBankingPort.requestExternalFirmBanking(new ExternalFirmBankingRequest(
				command.getFromBankName(),
				command.getFromBankAccountNumber(),
				command.getToBankName(),
				command.getToBankAccountNumber()
		));

		UUID randomUUID = UUID.randomUUID();
		requestedEntity.setUuid(randomUUID.toString());

		//3. 1번 요청 update ->
		if (result.getResultCode() == 0) {
			requestedEntity.setFirmBankingStatus(1);
		} else {
			requestedEntity.setFirmBankingStatus(2);
		}

		//4. 결과를 리턴
		return mapper.mapToDomainEntity(requestFirmBankingPort.modifyFirmBankingRequest(requestedEntity), randomUUID);
	}
}
