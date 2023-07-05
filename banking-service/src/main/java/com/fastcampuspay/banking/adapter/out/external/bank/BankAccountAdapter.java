package com.fastcampuspay.banking.adapter.out.external.bank;

import com.fashcampuspay.common.ExternalSystemAdapter;
import com.fastcampuspay.banking.adapter.out.persistence.FirmBankingRequestJpaEntity;
import com.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fastcampuspay.banking.application.port.out.RequestExternalFirmBankingPort;
import com.fastcampuspay.banking.application.port.out.RequestFirmBankingPort;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FirmBankingStatus;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FromBankAccountNumber;
import com.fastcampuspay.banking.domain.FirmBankingRequest.FromBankName;
import com.fastcampuspay.banking.domain.FirmBankingRequest.MoneyAmount;
import com.fastcampuspay.banking.domain.FirmBankingRequest.ToBankAccountNumber;
import com.fastcampuspay.banking.domain.FirmBankingRequest.ToBankName;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmBankingPort {

	@Override
	public BankAccount getBankAccountInfo(GetBankAccountRequest request) {

		//http를 통해서 실제 은행 계좌 정보를 가져오고
		//BankAccount로 파싱

		return new BankAccount(request.getBankName(), request.getBankAccountNumber(), true);
	}

	@Override
	public FirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request) {

		return new FirmBankingResult(1);
	}
}
