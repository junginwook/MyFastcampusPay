package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.membership.adapter.out.persistence.MemberShipJpaEntity;
import com.fastcampuspay.membership.adapter.out.persistence.MemberShipMapper;
import com.fastcampuspay.membership.application.port.in.ModifyMembershipCommand;
import com.fastcampuspay.membership.application.port.in.ModifyMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.ModifyMembershipPort;
import com.fastcampuspay.membership.domain.MemberShip;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipAddress;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipEmail;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipId;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipIsCorp;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipIsValid;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipName;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class ModifyMembershipService implements ModifyMembershipUseCase {

	private final ModifyMembershipPort modifyMembershipPort;
	private final MemberShipMapper memberShipMapper;

	@Override
	public MemberShip modifyMembership(ModifyMembershipCommand command) {

		//command -> DB
		MemberShipJpaEntity jpaEntity = modifyMembershipPort.modifyMemberShip(
				new MemberShipId(command.getMembershipId()),
				new MemberShipName(command.getName()),
				new MemberShipEmail(command.getEmail()),
				new MemberShipAddress(command.getAddress()),
				new MemberShipIsValid(command.isValid()),
				new MemberShipIsCorp(command.isCorp())
		);

		// entity -> MemberShip
		return memberShipMapper.mapToDomainEntity(jpaEntity);
	}
}
