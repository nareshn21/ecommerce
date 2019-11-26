package com.hcl.ecommerce.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.dto.ProductResponseDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.InvalidProductException;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.service.ProductServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	@Mock
	ProductRepository productRepository;
	ProductResponseDto productResponseDto;
	ProductDto productDto;
	Product product;
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
	Product getRegisterProduct() {
		Product product=new Product();
		product.setProductId(1);
		product.setProductName("mobile");
		product.setBrandName("vivo");
		product.setProductPrice(5000);

		return product;
	}
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		product=getRegisterProduct();
		productResponseDto = getRegisterProductResponseDto();
		productDto=getRegisterProductDto();
	}
	@Test
	public void testProductRegister() throws InvalidProductException {
	
		Optional<Product> products=Optional.of(product);
		Mockito.when(productRepository.findByBrandName("nokia")).thenReturn(products);
		Mockito.when(productRepository.save(Mockito.any())).thenReturn(product);
		ProductResponseDto response=productServiceImpl.registerProduct(productDto);
		assertEquals("product registered successfully", response.getMessage());
	}
}
