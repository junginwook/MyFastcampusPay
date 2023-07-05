package com.fastcampuspay.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class BankAccount {

	@Getter private String bankName;
	@Getter private String bankAccountNumber;
	@Getter private boolean isValid;
}
