package com.hcl.ecommerce.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.dto.UserResponseDto;
import com.hcl.ecommerce.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class UserControllerTest {
	@InjectMocks
	UserController userController;
	@Mock
	UserServiceImpl userServiceImpl;
	MockMvc mockMvc;
	UserResponseDto userResponseDto;
	UserDto userDto;
	public UserResponseDto getUserRegisterResponseDto() {
		UserResponseDto userResponseDto=new UserResponseDto();
		userResponseDto.setMessage("user register successfully");
		userResponseDto.setStatusCode(201);
		return userResponseDto;
	}
	public UserDto getUserRegisterDto() {
		UserDto userDto=new UserDto();
		userDto.setUserName("user1");
		userDto.setPassword("user1@123");
		userDto.setMobileNo(9916438755L);
		userDto.setUserLocation("Bangalore");
		return userDto;
	}
	@Before
	public void setup()
	{
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		userResponseDto = getUserRegisterResponseDto();
		userDto = getUserRegisterDto();
	}
	@Test
	public void testUserRegister() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(userDto)))
				.andExpect(status().isOk());
	}
	private static String  asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
