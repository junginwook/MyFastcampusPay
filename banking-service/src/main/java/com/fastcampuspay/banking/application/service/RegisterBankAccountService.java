package com.fastcampuspay.banking.application.service;

import com.fashcampuspay.common.UseCase;
import com.fastcampuspay.banking.adapter.out.external.bank.BankAccount;
import com.fastcampuspay.banking.adapter.out.external.bank.GetBankAccountRequest;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.fastcampuspay.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.fastcampuspay.banking.application.port.in.RegisterBankAccountUseCase;
import com.fastcampuspay.banking.application.port.in.RegisteredBanAccountCommand;
import com.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import com.fastcampuspay.banking.application.port.out.RequestBankAccountInfoPort;
import com.fastcampuspay.banking.domain.RegisteredBankAccount;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.BankAccountNumber;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.BankName;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.LinkedStatusIsValid;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.MembershipId;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

	private final RegisterBankAccountPort registerBankAccountPort;
	private final RegisteredBankAccountMapper mapper;
	private final RequestBankAccountInfoPort requestBankAccountInfoPort;
	@Override
	public RegisteredBankAccount registerBankAccount(RegisteredBanAccountCommand command) {

		// 은행 계좌를 등록해야 하는 서비스
		//1. 등록된 계좌인지 확인한다.
		//외부의 은행에 이 계좌 정상인가?
		//biz Logic -> external system
		//port -> adapter -> external system

		BankAccount accountInfo = requestBankAccountInfoPort.getBankAccountInfo(new GetBankAccountRequest(command.getBankName(), command.getBankAccountNumber()));
		boolean accountIsValid = accountInfo.isValid();

		//2. 등록 가능한 계좌라면, 등록한다. 성공하면 등록에 성공한 등록 정보를 리턴
		//2-1. 등록가능하지 않은 계좌라면, 에러를 리턴
		if (accountIsValid == true) {

			RegisteredBankAccountJpaEntity savedAccountInfo = registerBankAccountPort.createRegisteredBankAccount(
					new MembershipId(command.getMembershipId()),
					new BankName(command.getMembershipId()),
					new BankAccountNumber(command.getMembershipId()),
					new LinkedStatusIsValid(command.isValid())
			);

			return mapper.mapToDomainEntity(savedAccountInfo);
		} else {
			return null;
		}
	}
}
