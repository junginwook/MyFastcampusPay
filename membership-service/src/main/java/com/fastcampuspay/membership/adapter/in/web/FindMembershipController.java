package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.common.WebAdapter;
import com.fastcampuspay.membership.application.port.in.FindMembershipCommand;
import com.fastcampuspay.membership.application.port.in.FindMembershipUseCase;
import com.fastcampuspay.membership.domain.MemberShip;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindMembershipController {

	private final FindMembershipUseCase findMembershipUseCase;

	@GetMapping(path = "/membership/{membershipId}")
	ResponseEntity<MemberShip> findMembershipByMemberId(@RequestBody FindMembershipRequest request) {

		FindMembershipCommand command = FindMembershipCommand.builder()
				.membershipId(request.getMembershipId())
				.build();

		return ResponseEntity.ok(findMembershipUseCase.findMembership(command));
	}
}
