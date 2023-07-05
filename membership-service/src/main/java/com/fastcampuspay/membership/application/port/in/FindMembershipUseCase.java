package com.fastcampuspay.membership.application.port.in;

import com.fastcampuspay.membership.domain.MemberShip;

public interface FindMembershipUseCase {

	MemberShip findMembership(FindMembershipCommand command);
}
