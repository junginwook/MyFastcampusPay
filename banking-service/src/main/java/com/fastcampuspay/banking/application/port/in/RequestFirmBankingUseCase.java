package com.fastcampuspay.banking.application.port.in;

import com.fastcampuspay.common.UseCase;
import com.fastcampuspay.banking.domain.FirmBankingRequest;

@UseCase
public interface RequestFirmBankingUseCase {

	FirmBankingRequest requestFirmBanking(RequestFirmBankingCommand command);
}
