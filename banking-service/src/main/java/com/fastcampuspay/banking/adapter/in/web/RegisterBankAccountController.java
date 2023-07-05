package com.fastcampuspay.banking.adapter.in.web;

import com.fashcampuspay.common.WebAdapter;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountUseCase;
import com.fastcampuspay.banking.application.port.in.RegisteredBanAccountCommand;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

	private final RegisterBankAccountUseCase registerBankAccountUseCase;

	@PostMapping(path = "/banking/account/register")
	RegisteredBankAccount registerMemberShip(
			@RequestBody RegisterBankAccountRequest request
	) {
		RegisteredBanAccountCommand command = RegisteredBanAccountCommand.builder()
				.membershipId(request.getMembershipId())
				.bankName(request.getBankName())
				.bankAccountNumber(request.getBankAccountNumber())
				.isValid(request.isValid())
				.build();

		RegisteredBankAccount registeredBankAccount = registerBankAccountUseCase.registerBankAccount(command);
		if (registeredBankAccount == null) {
			// TODO: Error Handling
			return null;
		}
		return registeredBankAccount;
	}
}
