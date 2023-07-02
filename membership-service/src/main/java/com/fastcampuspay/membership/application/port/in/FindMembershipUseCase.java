package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.membership.application.port.in.domain.MemberShip;

public interface FindMembershipUseCase {

	MemberShip findMembership(FindMembershipCommand command);
}
