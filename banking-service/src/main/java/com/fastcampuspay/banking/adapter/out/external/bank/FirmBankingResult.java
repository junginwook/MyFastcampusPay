package com.fastcampuspay.banking.adapter.out.external.bank;

import lombok.Data;

@Data
public class FirmBankingResult {

	private int resultCode; //0성공, 1실패

	public FirmBankingResult(int resultCode) {
		this.resultCode = resultCode;
	}
}
