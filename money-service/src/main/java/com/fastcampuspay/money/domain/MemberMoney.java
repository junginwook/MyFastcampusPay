package com.fastcampuspay.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoney {

	@Getter private final Long memberMoneyId;

	@Getter private final Long membershipId;
	// 잔액
	@Getter private final int balance;

//	@Getter private final int linkedBankAccount;

	//Membership
	//오염이 되면 안되는 클래스, 고객 정보, 핵심 도메인
	//안전하게 사용될 수 있도록
	public static MemberMoney generateMemberMoney (
			MemberMoneyId memberMoneyId,
			MembershipId membershipId,
			MoneyBalance moneyBalance
	) {
		return new MemberMoney(
				memberMoneyId.memberMoneyId,
				membershipId.membershipId,
				moneyBalance.moneyBalance
		);
	}

	@Value
	public static class MemberMoneyId {
		Long memberMoneyId;

		public MemberMoneyId(Long value) {
			this.memberMoneyId = value;
		}
	}

	@Value
	public static class MembershipId {
		Long membershipId;

		public MembershipId(Long value) {
			this.membershipId = value;
		}
	}

	@Value
	public static class MoneyBalance {
		int moneyBalance;

		public MoneyBalance(int value) {
			this.moneyBalance = value;
		}
	}
}
