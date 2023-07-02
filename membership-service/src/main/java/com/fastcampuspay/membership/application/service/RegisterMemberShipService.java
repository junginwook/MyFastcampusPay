package com.fastcampuspay.membership.application.service;

import com.fastcampuspay.membership.adapter.out.persistence.MemberShipJpaEntity;
import com.fastcampuspay.membership.adapter.out.persistence.MemberShipMapper;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipAddress;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipEmail;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipIsCorp;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipIsValid;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipName;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterMemberShipService implements RegisterMembershipUseCase {

	private final RegisterMembershipPort registerMembershipPort;
	private final MemberShipMapper memberShipMapper;

	@Override
	public MemberShip registerMemberShip(RegisterMembershipCommand command) {
		//command -> DB
		MemberShipJpaEntity jpaEntity = registerMembershipPort.createMemberShip(
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
