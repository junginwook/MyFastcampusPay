package com.fastcampuspay.streamtest.application.port.in;

import com.fastcampuspay.common.UseCase;

@UseCase
public interface KafkaTestUseCase {
	void registerMessage();
}
