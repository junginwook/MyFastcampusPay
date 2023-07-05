package com.fastcampuspay.membership.application.service;

import com.fashcampuspay.common.UseCase;
import com.fastcampuspay.membership.adapter.out.persistence.MemberShipJpaEntity;
import com.fastcampuspay.membership.adapter.out.persistence.MemberShipMapper;
import com.fastcampuspay.membership.application.port.in.FindMembershipCommand;
import com.fastcampuspay.membership.application.port.in.FindMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.domain.MemberShip;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class FindMembershipService implements FindMembershipUseCase {

	private final FindMembershipPort findMembershipPort;
	private final MemberShipMapper memberShipMapper;

	@Override
	public MemberShip findMembership(FindMembershipCommand command) {
		MemberShipJpaEntity membershipEntity = findMembershipPort.findMembership(new MemberShipId(command.getMembershipId()));
		return memberShipMapper.mapToDomainEntity(membershipEntity);
	}
}
