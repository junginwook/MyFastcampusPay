package com.fastcampuspay.money;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.fashcampuspay.common", "com.fastcampuspay.money"})
public class MoneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyApplication.class);
	}
}
