package com.fastcampuspay.banking.adapter.out.persistence;

import com.fashcampuspay.common.PersistenceAdapter;
import com.fastcampuspay.banking.application.port.out.RegisterBankAccountPort;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.BankAccountNumber;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.BankName;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.LinkedStatusIsValid;
import com.fastcampuspay.banking.domain.RegisteredBankAccount.MembershipId;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class RegisteredBankAccountPersistenceAdapter implements RegisterBankAccountPort {

	private final SpringDataRegisteredBankAccountRepository bankAccountRepository;

	@Override
	public RegisteredBankAccountJpaEntity createRegisteredBankAccount(MembershipId membershipId, BankName bankName, BankAccountNumber bankAccountNumber, LinkedStatusIsValid linkedStatusIsValid) {
		return bankAccountRepository.save(
				new RegisteredBankAccountJpaEntity(
					membershipId.getMembershipId(),
					bankName.getBankName(),
					bankAccountNumber.getBankAccountNumber(),
					linkedStatusIsValid.isLinkedStatusIsValid()
				)
		);
	}
}
