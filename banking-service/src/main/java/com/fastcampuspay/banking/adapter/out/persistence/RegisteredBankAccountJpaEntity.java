package com.fastcampuspay.banking.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "registered_bank_account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredBankAccountJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long registeredBankAccountId;
	private String memberShipId;

	private String bankName;

	private String bankAccountNumber;

	private boolean linkedStatusIsValid;

	public RegisteredBankAccountJpaEntity(String memberShipId, String bankName, String bankAccountNumber, boolean linkedStatusIsValid) {
		this.memberShipId = memberShipId;
		this.bankName = bankName;
		this.bankAccountNumber = bankAccountNumber;
		this.linkedStatusIsValid = linkedStatusIsValid;
	}

	@Override
	public String toString() {
		return "RegisteredBankAccountJpaEntity{" +
				"registeredBankAccountId=" + registeredBankAccountId +
				", memberShipId='" + memberShipId + '\'' +
				", bankName='" + bankName + '\'' +
				", bankAccountNumber='" + bankAccountNumber + '\'' +
				", linkedStatusIsValid=" + linkedStatusIsValid +
				'}';
	}
}
