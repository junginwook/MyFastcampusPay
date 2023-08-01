package com.fashcampuspay.common.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtils {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
