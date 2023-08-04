package com.fastcampuspay.banking.adapter.out.service;

import com.fastcampuspay.banking.application.port.out.GetMembershipPort;
import com.fastcampuspay.banking.application.port.out.Membership;
import com.fastcampuspay.common.CommonHttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MembershipServiceAdapter implements GetMembershipPort {

	private final CommonHttpClient commonHttpClient;

	private final String memberShipServiceUrl;

	public MembershipServiceAdapter(CommonHttpClient commonHttpClient,
			@Value("${service.membership.url}") String memberShipServiceUrl) {
		this.commonHttpClient = commonHttpClient;
		this.memberShipServiceUrl = memberShipServiceUrl;
	}

	@Override
	public MembershipStatus getMembership(String membershipId) {

		String url = String.join("/", memberShipServiceUrl, "membership", membershipId);

		try {
			String jsonResponse = commonHttpClient.sendGetRequest(url).body();
			// json Membership

			ObjectMapper mapper = new ObjectMapper();
			Membership membership = mapper.readValue(jsonResponse, Membership.class);

			if (membership.isValid()) {
				return new MembershipStatus(membership.getMemberShipId(), true);
			} else {
				return new MembershipStatus(membership.getMemberShipId(), false);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
