package com.fastcampuspay.membership.application.port.in;

import com.fashcampuspay.common.SelfValidating;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {

	@NotNull
	private final String membershipId;
	@NotNull
	private final String name;

	@NotNull
	private final String email;

	@NotNull
	private final String address;

	@AssertTrue
	private final boolean isValid;

	@NotNull
	private final boolean isCorp;

	public ModifyMembershipCommand(String membershipId, String name, String email, String address, boolean isValid, boolean isCorp) {
		this.membershipId = membershipId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.isValid = isValid;
		this.isCorp = isCorp;

		this.validateSelf();
	}
}