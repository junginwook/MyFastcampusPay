package com.fastcampuspay.streamtest.adapter.out.external;

import com.fashcampuspay.common.ExternalSystemAdapter;
import com.fastcampuspay.streamtest.application.port.out.KafkaTestPort;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class KafkaTestAdapter implements KafkaTestPort {

	private final StreamBridge streamBridge;

	@Override
	public void registerKafkaMessage(TestMessage message) {
		streamBridge.send("kafka-test-out-0", message);
	}
}
