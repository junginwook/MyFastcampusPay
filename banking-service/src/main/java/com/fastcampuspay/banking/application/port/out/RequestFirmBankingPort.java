package com.fastcampuspay.banking.application.port.out;

import com.fastcampuspay.banking.adapter.out.external.bank.BankAccount;
import com.fastcampuspay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.fastcampuspay.banking.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.fastcampuspay.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingPort {
	FirmBankingRequestJpaEntity createFirmBankingRequest(
			FirmBankingRequest.FromBankName fromBankName,
			FirmBankingRequest.FromBankAccountNumber fromBankAccountNumber,
			FirmBankingRequest.ToBankName toBankName,
			FirmBankingRequest.ToBankAccountNumber toBankAccountNumber,
			FirmBankingRequest.MoneyAmount moneyAmount,
			FirmBankingRequest.FirmBankingStatus firmBankingStatus
	);

	FirmBankingRequestJpaEntity modifyFirmBankingRequest(
			FirmBankingRequestJpaEntity entity
	);
}
