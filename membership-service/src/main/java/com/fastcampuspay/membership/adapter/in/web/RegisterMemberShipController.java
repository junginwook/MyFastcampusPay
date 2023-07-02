package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip;
import common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMemberShipController {

	private final RegisterMembershipUseCase registerMemberShipUseCase;

	@PostMapping(path = "/membership/register")
	MemberShip registerMemberShip(
			@RequestBody RegisterMemberShipRequest request
	) {
		RegisterMembershipCommand command = RegisterMembershipCommand.builder()
				.name(request.getName())
				.address(request.getAddress())
				.email(request.getEmail())
				.isValid(true)
				.isCorp(request.isCorp())
				.build();

		return registerMemberShipUseCase.registerMemberShip(command);
	}
}
