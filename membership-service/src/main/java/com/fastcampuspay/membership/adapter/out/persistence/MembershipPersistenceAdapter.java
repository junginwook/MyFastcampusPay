package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipAddress;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipEmail;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipId;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipIsCorp;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipIsValid;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipName;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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

	@Override
	public MemberShipJpaEntity modifyMemberShip(MemberShipId memberShipId, MemberShipName memberShipName, MemberShipEmail memberShipEmail, MemberShipAddress memberShipAddress,
			MemberShipIsValid memberShipIsValid, MemberShipIsCorp memberShipIsCorp) {
		MemberShipJpaEntity entity = membershipRepository.getById(Long.parseLong(memberShipId.getMemberShipId()));
		entity.setName(memberShipName.getMemberShipName());
		entity.setAddress(memberShipAddress.getMemberShipAddress());
		entity.setEmail(memberShipEmail.getMemberShipEmail());
		entity.setCorp(memberShipIsCorp.isMemberShipIsCorp());
		entity.setValid(memberShipIsValid.isMemberShipIsValid());

		return membershipRepository.save(entity);
	}
}
