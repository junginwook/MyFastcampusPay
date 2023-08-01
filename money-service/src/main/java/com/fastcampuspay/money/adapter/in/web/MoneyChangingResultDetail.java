package com.fastcampuspay.money.adapter.in.web;

import com.fastcampuspay.money.domain.MoneyChangingRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

	private String moneyChangingRequestId;
	//증액 감액
	private int moneyChangingType; //0: 증액, 1: 감액

	private int moneyChangingResultStatus; //0: 성공, 1: 실패, 2: 잔액 부족, 3 - 맵버십 없음, 4 머니 변액 요청 없음

	private int amount;
}
