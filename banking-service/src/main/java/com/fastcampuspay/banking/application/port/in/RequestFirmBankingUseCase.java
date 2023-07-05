package com.fastcampuspay.banking.application.port.in;

import com.fashcampuspay.common.UseCase;
import com.fastcampuspay.banking.domain.FirmBankingRequest;

@UseCase
public interface RequestFirmBankingUseCase {

	FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command);
}
