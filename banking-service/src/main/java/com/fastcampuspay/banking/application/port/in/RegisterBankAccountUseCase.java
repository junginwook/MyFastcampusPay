package com.fastcampuspay.banking.application.port.in;

import com.fashcampuspay.common.UseCase;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;

@UseCase
public interface RegisterBankAccountUseCase {

	RegisteredBankAccount registerBankAccount(RegisteredBanAccountCommand command);
}
