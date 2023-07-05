package com.fastcampuspay.banking.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "request_firm_banking")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmBankingRequestJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requestFirmBankingId;
	private String fromBankName;
	private String fromBankAccountNumber;
	private String toBankName;
	private String toBankAccountNumber;
	private int moneyAmount;
	private int firmBankingStatus;

	private String uuid;

	public FirmBankingRequestJpaEntity(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount, int firmBankingStatus, UUID uuid) {
		this.fromBankName = fromBankName;
		this.fromBankAccountNumber = fromBankAccountNumber;
		this.toBankName = toBankName;
		this.toBankAccountNumber = toBankAccountNumber;
		this.moneyAmount = moneyAmount;
		this.firmBankingStatus = firmBankingStatus;
		this.uuid = uuid.toString();
	}

	@Override
	public String toString() {
		return "RequestFirmBankingJpaEntity{" +
				"requestFirmBankingId=" + requestFirmBankingId +
				", fromBankName='" + fromBankName + '\'' +
				", fromBankAccountNumber='" + fromBankAccountNumber + '\'' +
				", toBankName='" + toBankName + '\'' +
				", toBankAccountNumber='" + toBankAccountNumber + '\'' +
				", moneyAmount=" + moneyAmount +
				", firmBankingStatus=" + firmBankingStatus +
				'}';
	}
}
