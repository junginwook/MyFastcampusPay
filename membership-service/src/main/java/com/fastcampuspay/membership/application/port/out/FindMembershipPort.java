package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.MemberShipJpaEntity;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip;

public interface FindMembershipPort {
	MemberShipJpaEntity findMembership(
			MemberShip.MemberShipId memberShipId
	);
}
