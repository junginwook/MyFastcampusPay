package com.fastcampuspay.banking.adapter.out.external.bank;

import com.fashcampuspay.common.ExternalSystemAdapter;
import com.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fastcampuspay.banking.application.port.out.RequestExternalFirmBankingPort;
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
