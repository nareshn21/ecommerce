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
import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.dto.StoreResponseDto;
import com.hcl.ecommerce.service.StoreServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class StoreControllerTest {
	@InjectMocks
	StoreController storeController;
	@Mock
	StoreServiceImpl storeService;
	MockMvc mockMvc;
	StoreResponseDto storeResponseDto;
	StoreDto storeDto;
	StoreResponseDto getStoreRegisterResponseDto() {
		StoreResponseDto storeResponseDto=new StoreResponseDto();
		storeResponseDto.setMessage("store registered successfully");
		storeResponseDto.setStatusCode(200);
		return storeResponseDto;
	}
	StoreDto getStoreRegisterDto() {
		StoreDto storeDto=new StoreDto();
		storeDto.setProductId(1);
		storeDto.setProductDiscount(5);
		storeDto.setStoreName("Balaji Stores");
		storeDto.setStoreLocation("Bangalore");
		return storeDto;
	}
	@Before
	public void setUp()
	{
		mockMvc = MockMvcBuilders.standaloneSetup(storeController).build();
		storeDto = getStoreRegisterDto();
		storeResponseDto=getStoreRegisterResponseDto();
	}
	@Test
	public void testStoreRegister() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/stores").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(storeDto)))
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
