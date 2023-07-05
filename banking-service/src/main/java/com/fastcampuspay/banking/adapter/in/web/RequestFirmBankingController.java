package com.fastcampuspay.banking.adapter.in.web;

import com.fashcampuspay.common.WebAdapter;
import com.fastcampuspay.banking.application.port.in.RequestFirmBankingCommand;
import com.fastcampuspay.banking.application.port.in.RequestFirmBankingUseCase;
import com.fastcampuspay.banking.domain.FirmBankingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@WebAdapter
@RequiredArgsConstructor
public class RequestFirmBankingController {

	private final RequestFirmBankingUseCase requestFirmBankingUseCase;

	@PostMapping(path = "/banking/firmBanking/register")
	FirmBankingRequest requestFirmBanking(
			@RequestBody RequestFirmBankingRequest request
	) {
		RequestFirmBankingCommand command = RequestFirmBankingCommand.builder()
				.fromBankName(request.getFromBankName())
				.fromBankAccountNumber(request.getFromBankAccountNumber())
				.toBankName(request.getToBankName())
				.toBankAccountNumber(request.getToBankAccountNumber())
				.moneyAmount(request.getMoneyAmount())
				.build();

		return requestFirmBankingUseCase.requestFirmBanking(command);
	}
}
