package com.fastcampuspay.streamtest.adapter.in.web;

import com.fashcampuspay.common.WebAdapter;
import com.fastcampuspay.streamtest.application.port.in.KafkaTestUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@WebAdapter
@RequestMapping("/test")
@RequiredArgsConstructor
@Tag(value = "kafka stream test")
public class KafkaTestController {
	private final KafkaTestUseCase registerKafkaUseCase;

	@Operation(summary = "계좌 증액 요청", description = "회원의 계좌 증액", tags = { "Member Controller" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK"),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@PostMapping("/kafka/publish")
	public void kafkaTest() {
		registerKafkaUseCase.registerMessage();
	}
}
