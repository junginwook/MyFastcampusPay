package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.domain.MemberShip;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipAddress;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipEmail;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipId;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipIsCorp;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipIsValid;
import com.fastcampuspay.membership.domain.MemberShip.MemberShipName;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterMemberShipControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testRegisterMembership() throws Exception {
		RegisterMemberShipRequest request = new RegisterMemberShipRequest("name", "email", "address", true);

		MemberShip memberShip = MemberShip.generateMember(
				new MemberShipId("1"),
				new MemberShipName("name"),
				new MemberShipEmail("email"),
				new MemberShipAddress("address"),
				new MemberShipIsValid(true),
				new MemberShipIsCorp(true)
		);

		mockMvc.perform(
				MockMvcRequestBuilders.post("/membership/register")
						.contentType(MediaType.APPLICATION_JSON)
						.content(mapper.writeValueAsString(request))
		)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(mapper.writeValueAsString(memberShip)));

	}
}
