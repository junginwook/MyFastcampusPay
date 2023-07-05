package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.membership.domain.MemberShip;
import org.springframework.stereotype.Component;

@Component
public class MemberShipMapper {
	public MemberShip mapToDomainEntity(MemberShipJpaEntity memberShipJpaEntity) {
		return MemberShip.generateMember(
				new MemberShip.MemberShipId(memberShipJpaEntity.getMemberShipId() + ""),
				new MemberShip.MemberShipName(memberShipJpaEntity.getName()),
				new MemberShip.MemberShipEmail(memberShipJpaEntity.getEmail()),
				new MemberShip.MemberShipAddress(memberShipJpaEntity.getAddress()),
				new MemberShip.MemberShipIsValid(memberShipJpaEntity.isValid()),
				new MemberShip.MemberShipIsCorp(memberShipJpaEntity.isCorp())
		);
	}
}
