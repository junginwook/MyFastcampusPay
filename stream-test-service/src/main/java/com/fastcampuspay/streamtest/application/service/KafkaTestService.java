package com.fastcampuspay.streamtest.application.service;

import com.fashcampuspay.common.UseCase;
import com.fastcampuspay.streamtest.application.port.in.KafkaTestUseCase;
import com.fastcampuspay.streamtest.application.port.out.KafkaTestPort;
import com.fastcampuspay.streamtest.adapter.out.external.TestMessage;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class KafkaTestService implements KafkaTestUseCase {

	private final KafkaTestPort kafkaTestPort;

	@Override
	public void registerMessage() {
		kafkaTestPort.registerKafkaMessage(
				TestMessage.builder()
						.name("name")
						.address("address")
						.build());
	}
}
