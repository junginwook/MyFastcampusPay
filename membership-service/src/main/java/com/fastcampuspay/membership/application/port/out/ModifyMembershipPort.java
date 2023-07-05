package com.fastcampuspay.membership.application.port.out;

import com.fastcampuspay.membership.adapter.out.persistence.MemberShipJpaEntity;
import com.fastcampuspay.membership.domain.MemberShip;

public interface ModifyMembershipPort {

	MemberShipJpaEntity modifyMemberShip(
			MemberShip.MemberShipId memberShipId,
			MemberShip.MemberShipName memberShipName,
			MemberShip.MemberShipEmail memberShipEmail,
			MemberShip.MemberShipAddress memberShipAddress,
			MemberShip.MemberShipIsValid memberShipIsValid,
			MemberShip.MemberShipIsCorp memberShipIsCorp
	);
}
