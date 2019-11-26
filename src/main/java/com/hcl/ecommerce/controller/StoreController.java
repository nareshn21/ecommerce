package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.dto.StoreResponseDto;
import com.hcl.ecommerce.exception.InvalidStoreException;
import com.hcl.ecommerce.service.StoreService;

/**
 * @author Naresh
 * @Description
 *
 */
@RestController
@RequestMapping("/stores")
public class StoreController {
	@Autowired
	StoreService storeService;
	/**
	 * @Description
	 * @param storeDto
	 * @return
	 * @throws InvalidStoreException
	 */
	@PostMapping("")
	public StoreResponseDto storeRegister(StoreDto storeDto) throws InvalidStoreException{
		StoreResponseDto storeResponseDto=storeService.storeRegister(storeDto);
		return storeResponseDto;
		
	}


}
