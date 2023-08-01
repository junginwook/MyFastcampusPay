package com.fastcampuspay.money.domain;

import java.util.Date;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingRequest {
	@Getter private final String moneyChangingRequestId;

	//어떤 고객의 증액/감액 요청을 했는지
	@Getter private final Long targetMembershipId;

	// 그 요청이 증액 요청인지 감액 요청인지
	@Getter private final int changingType;

	// 증액 또는 감액 요청의 금액
	@Getter private final int changingMoneyAmount;

	// 머니 변액 요청에 대한 상태
	@Getter private final int changingMoneyStatus;

	@Getter private final String uuid;

	@Getter private final Date createdAt;

	//Membership
	//오염이 되면 안되는 클래스, 고객 정보, 핵심 도메인
	//안전하게 사용될 수 있도록
	public static MoneyChangingRequest generateMoneyChangingRequest (
			MoneyChangingRequestId moneyChangingRequestId,
			TargetMembershipId targetMembershipId,
			MoneyChangingType moneyChangingType,
			ChangingMoneyAmount changingMoneyAmount,
			MoneyChangingStatus moneyChangingStatus,
			Uuid uuid
	) {
		return new MoneyChangingRequest(
				moneyChangingRequestId.getMoneyChangingRequestId(),
				targetMembershipId.getTargetMembershipId(),
				moneyChangingType.getChangingType(),
				changingMoneyAmount.getChangingMoneyAmount(),
				moneyChangingStatus.getChangingMoneyStatus(),
				uuid.getUuid(),
				new Date()
		);
	}

	@Value
	public static class MoneyChangingRequestId {
		String moneyChangingRequestId;

		public MoneyChangingRequestId(String value) {
			this.moneyChangingRequestId = value;
		}
	}

	@Value
	public static class TargetMembershipId {
		Long targetMembershipId;

		public TargetMembershipId(Long value) {
			this.targetMembershipId = value;
		}
	}

	@Value
	public static class MoneyChangingType {
		int changingType;

		public MoneyChangingType(int value) {
			this.changingType = value;
		}
	}

	@Value
	public static class ChangingMoneyAmount {
		int changingMoneyAmount;

		public ChangingMoneyAmount(int value) {
			this.changingMoneyAmount = value;
		}
	}

	@Value
	public static class MoneyChangingStatus {
		int changingMoneyStatus;

		public MoneyChangingStatus(int value) {
			this.changingMoneyStatus = value;
		}
	}

	@Value
	public static class Uuid {
		String uuid;

		public Uuid(UUID uuid) {
			this.uuid = uuid.toString();
		}
	}
}
