package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.membership.application.port.in.domain.MemberShip;
import common.UseCase;

@UseCase
public interface RegisterMembershipUseCase {

	MemberShip registerMemberShip(RegisterMembershipCommand command);
}
