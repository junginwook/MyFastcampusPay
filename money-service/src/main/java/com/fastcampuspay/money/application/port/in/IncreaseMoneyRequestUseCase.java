package com.fastcampuspay.money.application.port.in;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.money.application.port.out.MembershipStatus;
import com.fastcampuspay.money.domain.MoneyChangingRequest;

@UseCase
public interface IncreaseMoneyRequestUseCase {

	MoneyChangingRequest increaseMoneyRequest(IncreaseMoneyRequestCommand command);
	MembershipStatus increaseMoneyRequestAsync(IncreaseMoneyRequestCommand command);
}
