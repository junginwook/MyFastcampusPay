package com.fastcampuspay.streamtest.application.port.out;

import com.fastcampuspay.streamtest.adapter.out.external.TestMessage;

public interface KafkaTestPort {
	void registerKafkaMessage(TestMessage message);
}
