package com.fastcampuspay.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

	@GetMapping(path = "/test")
	void test() {
		System.out.println("hello");
	}
}
