package com.fastcampuspay.membership.adapter.in.web;

import com.fastcampuspay.membership.application.port.in.domain.MemberShip;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipAddress;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipEmail;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipId;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipIsCorp;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipIsValid;
import com.fastcampuspay.membership.application.port.in.domain.MemberShip.MemberShipName;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
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
