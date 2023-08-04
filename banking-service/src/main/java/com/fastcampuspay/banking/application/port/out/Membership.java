package com.fastcampuspay.banking.application.port.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Membership { // for banking-service

	private String memberShipId;

	private String name;

	private String email;

	private String address;

	private boolean isValid;
}
