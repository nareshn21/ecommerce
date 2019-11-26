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
import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.dto.ProductResponseDto;
import com.hcl.ecommerce.service.ProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class ProductControllerTest {
	@InjectMocks
	ProductController productController;
	@Mock
	ProductServiceImpl productServiceImpl;
	
	MockMvc mockMvc;
	ProductResponseDto productResponseDto;
	ProductDto productDto;
	ProductResponseDto getRegisterProductResponseDto() {
		ProductResponseDto productResponseDto=new ProductResponseDto();
		productResponseDto.setMessage("product registered successfully");
		productResponseDto.setStatusCode(200);
		return productResponseDto;
	}
	ProductDto getRegisterProductDto() {
		ProductDto productDto=new ProductDto();
		productDto.setProductName("mobile");
		productDto.setProductPrice(5000);
		productDto.setProductName("vivo");
		return productDto;
	}
	@Before
	public void setUp()
	{
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
		productResponseDto = getRegisterProductResponseDto();
		productDto=getRegisterProductDto();
	}
	@Test
	public void testProductRegister() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/products").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(asJsonString(productDto)))
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
