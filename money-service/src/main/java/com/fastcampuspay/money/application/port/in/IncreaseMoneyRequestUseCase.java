package com.fastcampuspay.money.application.port.in;

import com.fashcampuspay.common.UseCase;
import com.fastcampuspay.money.domain.MoneyChangingRequest;

@UseCase
public interface IncreaseMoneyRequestUseCase {

	MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
}
