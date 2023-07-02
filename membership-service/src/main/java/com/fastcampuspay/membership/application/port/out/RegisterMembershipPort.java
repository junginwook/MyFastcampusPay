package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.MemberShipJpaEntity;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip;

public interface RegisterMembershipPort {

	MemberShipJpaEntity createMemberShip(
			MemberShip.MemberShipName memberShipName,
			MemberShip.MemberShipEmail memberShipEmail,
			MemberShip.MemberShipAddress memberShipAddress,
			MemberShip.MemberShipIsValid memberShipIsValid,
			MemberShip.MemberShipIsCorp memberShipIsCorp
	);
}
