package com.fastcampuspay.banking.domain;

import com.fastcampuspay.banking.domain.RegisteredBankAccount.BankAccountNumber;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.BankName;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.LinkedStatusIsValid;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.MembershipId;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.RegisteredBankAccountId;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FirmBankingRequest {

	@Getter private final String firmBankingRequestId;

	@Getter private final String fromBankName;

	@Getter private final String fromBankAccountNumber;

	@Getter private final String toBankName;

	@Getter private final String toBankAccountNumber;

	@Getter private final int moneyAmount;

	@Getter private final int firmBankingStatus;

	@Getter private final UUID uuid;
	public static FirmBankingRequest generateFirmBankingRequest(
			FirmBankingRequestId firmBankingRequestId,
			FromBankName fromBankName,
			FromBankAccountNumber fromBankAccountNumber,
			ToBankName toBankName,
			ToBankAccountNumber toBankAccountNumber,
			MoneyAmount moneyAmount,
			FirmBankingStatus firmBankingStatus,
			UUID uuid
	) {

		return new FirmBankingRequest(
				firmBankingRequestId.firmBankingRequestId,
				fromBankName.fromBankName,
				fromBankAccountNumber.fromBankAccountNumber,
				toBankName.toBankName,
				toBankAccountNumber.toBankAccountNumber,
				moneyAmount.moneyAmount,
				firmBankingStatus.firmBankingStatus,
				uuid
		);
	}

	@Value
	public static class FirmBankingRequestId {
		String firmBankingRequestId;

		public FirmBankingRequestId(String value) {
			this.firmBankingRequestId = value;
		}
	}

	@Value
	public static class FromBankName {
		String fromBankName;

		public FromBankName(String value) {
			this.fromBankName = value;
		}
	}

	@Value
	public static class FromBankAccountNumber {
		String fromBankAccountNumber;

		public FromBankAccountNumber(String value) {
			this.fromBankAccountNumber = value;
		}
	}

	@Value
	public static class ToBankName {
		String toBankName;

		public ToBankName(String value) {
			this.toBankName = value;
		}
	}

	@Value
	public static class ToBankAccountNumber {
		String toBankAccountNumber;

		public ToBankAccountNumber(String value) {
			this.toBankAccountNumber = value;
		}
	}

	@Value
	public static class MoneyAmount {
		int moneyAmount;

		public MoneyAmount(int value) {
			this.moneyAmount = value;
		}
	}

	@Value
	public static class FirmBankingStatus {
		int firmBankingStatus;

		public FirmBankingStatus(int value) {
			this.firmBankingStatus = value;
		}
	}
}
