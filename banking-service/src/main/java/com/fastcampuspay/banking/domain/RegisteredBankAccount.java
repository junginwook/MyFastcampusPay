package com.fastcampuspay.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisteredBankAccount {

	@Getter private final String registeredBankAccountId;

	@Getter private final String membershipId;

	@Getter private final String bankName;

	@Getter private final String bankAccountNumber;

	@Getter private final boolean linkedStatusIsValid;

	//Membership
	//오염이 되면 안되는 클래스, 고객 정보, 핵심 도메인
	//안전하게 사용될 수 있도록
	public static RegisteredBankAccount generateRegisteredBankAccount (
			RegisteredBankAccountId registeredBankAccountId,
			MembershipId membershipId,
			BankName bankName,
			BankAccountNumber bankAccountNumber,
			LinkedStatusIsValid linkedStatusIsValid
	) {
		return new RegisteredBankAccount(
				registeredBankAccountId.registeredBankAccountId,
				membershipId.membershipId,
				bankName.bankName,
				bankAccountNumber.bankAccountNumber,
				linkedStatusIsValid.linkedStatusIsValid
		);
	}

	@Value
	public static class RegisteredBankAccountId {
		String registeredBankAccountId;

		public RegisteredBankAccountId(String value) {
			this.registeredBankAccountId = value;
		}
	}

	@Value
	public static class MembershipId {
		String membershipId;

		public MembershipId(String value) {
			this.membershipId = value;
		}
	}

	@Value
	public static class BankName {
		String bankName;

		public BankName(String value) {
			this.bankName = value;
		}
	}

	@Value
	public static class BankAccountNumber {
		String bankAccountNumber;

		public BankAccountNumber(String value) {
			this.bankAccountNumber = value;
		}
	}

	@Value
	public static class LinkedStatusIsValid {
		boolean linkedStatusIsValid;

		public LinkedStatusIsValid(boolean value) {
			this.linkedStatusIsValid = value;
		}
	}
}
