package com.fastcampuspay.banking.adapter.out.persistence;

import com.fastcampuspay.common.ExternalSystemAdapter;
import com.fastcampuspay.banking.application.port.out.RequestFirmBankingPort;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FirmBankingStatus;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FromBankAccountNumber;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FromBankName;
import com.fastcampuspay.banking.domain.FirmBankingRequest.MoneyAmount;
import com.fastcampuspay.banking.domain.FirmBankingRequest.ToBankAccountNumber;
import com.fastcampuspay.banking.domain.FirmBankingRequest.ToBankName;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class FirmBankingRequestPersistenceAdapter implements RequestFirmBankingPort {

	private final SpringDataFirmBankingRepository firmBankingRequestRepository;

	@Override
	public FirmBankingRequestJpaEntity createFirmBankingRequest(FromBankName fromBankName, FromBankAccountNumber fromBankAccountNumber, ToBankName toBankName, ToBankAccountNumber toBankAccountNumber,
			MoneyAmount moneyAmount, FirmBankingStatus firmBankingStatus) {

		return firmBankingRequestRepository.save(new FirmBankingRequestJpaEntity(
			fromBankName.getFromBankName(),
			fromBankAccountNumber.getFromBankAccountNumber(),
			toBankName.getToBankName(),
			toBankAccountNumber.getToBankAccountNumber(),
			moneyAmount.getMoneyAmount(),
			firmBankingStatus.getFirmBankingStatus(),
			UUID.randomUUID()
		));
	}

	@Override
	public FirmBankingRequestJpaEntity modifyFirmBankingRequest(FirmBankingRequestJpaEntity entity) {
		return firmBankingRequestRepository.save(entity);
	}
}
