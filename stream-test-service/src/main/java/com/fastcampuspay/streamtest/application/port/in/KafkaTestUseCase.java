package com.fastcampuspay.streamtest.application.port.in;

import com.fashcampuspay.common.UseCase;

@UseCase
public interface KafkaTestUseCase {
	void registerMessage();
}
