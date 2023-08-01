package com.fastcampuspay.money.adapter.out.persistence;

import com.fastcampuspay.money.domain.MoneyChangingRequest;
import com.fastcampuspay.money.domain.MoneyChangingRequest.ChangingMoneyAmount;
import com.fastcampuspay.money.domain.MoneyChangingRequest.MoneyChangingStatus;
import com.fastcampuspay.money.domain.MoneyChangingRequest.MoneyChangingType;
import com.fastcampuspay.money.domain.MoneyChangingRequest.TargetMembershipId;
import com.fastcampuspay.money.domain.MoneyChangingRequest.Uuid;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {
	public MoneyChangingRequest mapToDomainEntity(MoneyChangingRequestJpaEntity moneyChangingResultJpaEntity) {
		return MoneyChangingRequest.generateMoneyChangingRequest(
			new MoneyChangingRequest.MoneyChangingRequestId(moneyChangingResultJpaEntity.getMoneyChangingRequestId() + ""),
			new TargetMembershipId(moneyChangingResultJpaEntity.getTargetMemberShipId()),
			new MoneyChangingType(moneyChangingResultJpaEntity.getMoneyChangingType()),
			new ChangingMoneyAmount(moneyChangingResultJpaEntity.getMoneyAmount()),
			new MoneyChangingStatus(moneyChangingResultJpaEntity.getChangingMoneyStatus()),
			new Uuid(moneyChangingResultJpaEntity.getUuid())
		);
	}
}
