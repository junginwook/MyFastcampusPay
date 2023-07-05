package com.fastcampuspay.banking.application.port.in;

import com.fashcampuspay.common.SelfValidating;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisteredBanAccountCommand extends SelfValidating<RegisteredBanAccountCommand> {

	@NotNull
	private final String membershipId;

	@NotNull
	private final String bankName;

	@NotNull
	@NotBlank
	private final String bankAccountNumber;

	private final boolean isValid;

	public RegisteredBanAccountCommand(String membershipId, String bankName, String bankAccountNumber, boolean isValid) {
		this.membershipId = membershipId;
		this.bankName = bankName;
		this.bankAccountNumber = bankAccountNumber;
		this.isValid = isValid;

		this.validateSelf();
	}
}
