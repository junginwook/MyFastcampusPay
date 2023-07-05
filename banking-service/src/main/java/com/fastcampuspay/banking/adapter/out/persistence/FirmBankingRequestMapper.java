package com.fastcampuspay.banking.adapter.out.persistence;

import static com.fastcampuspay.banking.domain.FirmBankingRequest.*;

import com.fastcampuspay.banking.domain.FirmBankingRequest;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FirmBankingRequestId;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FromBankName;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class FirmBankingRequestMapper {
	public FirmBankingRequest mapToDomainEntity(FirmBankingRequestJpaEntity requestFirmBankingJpaEntity, UUID uuid) {
		return generateFirmBankingRequest(
				new FirmBankingRequestId(requestFirmBankingJpaEntity.getRequestFirmBankingId() + ""),
				new FromBankName(requestFirmBankingJpaEntity.getFromBankName()),
				new FromBankAccountNumber(requestFirmBankingJpaEntity.getFromBankAccountNumber()),
				new ToBankName(requestFirmBankingJpaEntity.getToBankName()),
				new ToBankAccountNumber(requestFirmBankingJpaEntity.getToBankAccountNumber()),
				new MoneyAmount(requestFirmBankingJpaEntity.getMoneyAmount()),
				new FirmBankingStatus(requestFirmBankingJpaEntity.getFirmBankingStatus()),
				uuid
		);
	}
}
