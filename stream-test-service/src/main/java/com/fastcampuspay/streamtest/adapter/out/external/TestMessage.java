package com.fastcampuspay.streamtest.adapter.out.external;

import lombok.Builder;

public class TestMessage {
	private String name;
	private String address;

	@Builder
	public TestMessage(String name, String address) {
		this.name = name;
		this.address = address;
	}
}
