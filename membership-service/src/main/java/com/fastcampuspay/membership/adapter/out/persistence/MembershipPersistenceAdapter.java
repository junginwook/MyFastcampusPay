package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipAddress;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipEmail;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipId;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipIsCorp;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipIsValid;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipName;
import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

	private final SpringDataMembershipRepository membershipRepository;

	@Override
	public MemberShipJpaEntity createMemberShip(MemberShipName memberShipName, MemberShipEmail memberShipEmail, MemberShipAddress memberShipAddress, MemberShipIsValid memberShipIsValid, MemberShipIsCorp memberShipIsCorp) {
		return membershipRepository.save(
				new MemberShipJpaEntity(
					memberShipName.getMemberShipName(),
					memberShipEmail.getMemberShipEmail(),
					memberShipAddress.getMemberShipAddress(),
					memberShipIsValid.isMemberShipIsValid(),
					memberShipIsCorp.isMemberShipIsCorp()
				)
		);
	}

	@Override
	public MemberShipJpaEntity findMembership(MemberShipId memberShipId) {
		return membershipRepository.getById(Long.parseLong(memberShipId.getMemberShipId()));
	}
}
