package com.fastcampuspay.membership.application.port.in;

import com.fashcampuspay.common.UseCase;
import com.fastcampuspay.membership.domain.MemberShip;

@UseCase
public interface RegisterMembershipUseCase {

	MemberShip registerMemberShip(RegisterMembershipCommand command);
}
