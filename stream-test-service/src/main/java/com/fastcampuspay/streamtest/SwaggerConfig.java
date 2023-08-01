package com.fastcampuspay.streamtest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
		info = @Info(title = "Stream Test Service API",
				description = "Stream Test",
				version = "v1"))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi chatOpenApi() {
		String[] paths = {"/test/**"};

		return GroupedOpenApi.builder()
				.group("Steam Test Service API")
				.pathsToMatch(paths)
				.build();
	}
}