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

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.dto.StoreResponseDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.exception.InvalidStoreException;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.service.StoreServiceImpl;
@RunWith(SpringJUnit4ClassRunner.class)
public class StoreServiceImplTest {
	
	@InjectMocks
	StoreServiceImpl storeService;
	
	@Mock
	StoreRepository storeRepository;
	
	StoreResponseDto storeResponseDto;
	StoreDto storeDto;
	Store store;
	StoreResponseDto getStoreRegisterResponseDto() {
		StoreResponseDto storeResponseDto=new StoreResponseDto();
		storeResponseDto.setMessage("store registered successfully");
		storeResponseDto.setStatusCode(201);
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
	
	Store getRegisterStore() {
		Store store=new Store();
		store.setStoreId(1);
		store.setProductId(1);
		store.setProductId(5);
		store.setStoreName("Balaji Stores");
		store.setStoreLocation("Bangalore");
		return store;
	}
	@Before
	public void init()
	{
		MockitoAnnotations.initMocks(this);
		store=getRegisterStore();
		storeDto = getStoreRegisterDto();
		storeResponseDto=getStoreRegisterResponseDto();
	}
	@Test
	public void testStoreRegister() throws InvalidStoreException {
		Optional<Store> optionalStore =Optional.of(store);
		
		Mockito.when(storeRepository.findByStoreName("Raj")).thenReturn(optionalStore);
		Mockito.when(storeRepository.save(Mockito.any())).thenReturn(store);
		
		StoreResponseDto response = storeService.storeRegister(storeDto);
		assertEquals("store registered successfully", response.getMessage());
}
	
}
