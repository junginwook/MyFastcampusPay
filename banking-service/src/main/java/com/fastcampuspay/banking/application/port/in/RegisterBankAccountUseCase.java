package com.fastcampuspay.banking.application.port.in;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;

@UseCase
public interface RegisterBankAccountUseCase {

	RegisteredBankAccount registerBankAccount(RegisteredBanAccountCommand command);
}
