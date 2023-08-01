package com.fastcampuspay.money.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "money_changing_request")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingRequestJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long moneyChangingRequestId;
	private Long targetMemberShipId;

	private int moneyChangingType; //0: 증액 1: 감액

	private int moneyAmount;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	private int changingMoneyStatus;

	private UUID uuid;

	public MoneyChangingRequestJpaEntity(Long targetMemberShipId, int moneyChangingType, int moneyAmount, Timestamp timestamp, int changingMoneyStatus, UUID uuid) {
		this.targetMemberShipId = targetMemberShipId;
		this.moneyChangingType = moneyChangingType;
		this.moneyAmount = moneyAmount;
		this.timestamp = timestamp;
		this.changingMoneyStatus = changingMoneyStatus;
		this.uuid = uuid;
	}
}
