package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.domain.MemberShip;

@UseCase
public interface RegisterMembershipUseCase {

	MemberShip registerMemberShip(RegisterMembershipCommand command);
}
