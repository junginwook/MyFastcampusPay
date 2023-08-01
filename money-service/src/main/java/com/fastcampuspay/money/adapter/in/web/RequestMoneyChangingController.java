package com.fastcampuspay.money.adapter.in.web;

import com.fashcampuspay.common.WebAdapter;
import com.fastcampuspay.money.application.port.in.IncreaseMoneyRequestCommand;
import com.fastcampuspay.money.application.port.in.IncreaseMoneyRequestUseCase;
import com.fastcampuspay.money.domain.MoneyChangingRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Tag(value = "입출금 기능")
public class RequestMoneyChangingController {

	private final IncreaseMoneyRequestUseCase increaseMoneyRequestUseCase;

	@Operation(summary = "계좌 증액 요청", description = "회원의 계좌 증액", tags = { "Member Controller" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK",
					content = @Content(schema = @Schema(implementation = MoneyChangingResultDetail.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@PostMapping(path = "/v1/money/increase")
	MoneyChangingResultDetail increaseMoneyChangingRequest(
			@RequestBody IncreaseMoneyChangingRequest request
	) {
		IncreaseMoneyRequestCommand command = IncreaseMoneyRequestCommand.builder()
				.targetMembershipId(request.getTargetMembershipId())
				.amount(request.getAmount())
				.build();

		MoneyChangingRequest moneyChangingRequest = increaseMoneyRequestUseCase.increaseMoneyRequest(command);

		return new MoneyChangingResultDetail(
				moneyChangingRequest.getMoneyChangingRequestId(),
				moneyChangingRequest.getChangingType(),
				moneyChangingRequest.getChangingMoneyStatus(),
				moneyChangingRequest.getChangingMoneyAmount()
		);
	}

	@Operation(summary = "hello, world api", description = "hellow world swagger check")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = MoneyChangingResultDetail.class))),
			@ApiResponse(responseCode = "400", description = "BAD REQUEST"),
			@ApiResponse(responseCode = "404", description = "NOT FOUND"),
			@ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
	})
	@PostMapping(path = "/v1/money/decrease")
	MoneyChangingResultDetail decreaseMoneyChangingRequest(
			@RequestBody IncreaseMoneyChangingRequest request
	) {
//		RegisteredBanAccountCommand command = RegisteredBanAccountCommand.builder()
//				.membershipId(request.getMembershipId())
//				.bankName(request.getBankName())
//				.bankAccountNumber(request.getBankAccountNumber())
//				.isValid(request.isValid())
//				.build();

		return null;
	}
}
