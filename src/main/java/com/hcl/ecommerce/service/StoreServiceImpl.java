package com.hcl.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.dto.StoreResponseDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.exception.InvalidStoreException;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.util.ECommerceConstants;

/**
 * @author Naresh
 * @Description
 *
 */
@Service
public class StoreServiceImpl implements StoreService {
@Autowired
StoreRepository storeRepository;
	/**
	 * @Description
	 *
	 */
	@Override
	public StoreResponseDto storeRegister(StoreDto storeDto) throws InvalidStoreException {
		StoreResponseDto storeResponseDto=null;
		Optional<Store> store=storeRepository.findByStoreName(storeDto.getStoreName());
		if(!store.isPresent()) {
			storeResponseDto=new StoreResponseDto();
			Store stores=new Store();
			BeanUtils.copyProperties(storeDto, stores);
			storeRepository.save(stores);
			storeResponseDto.setMessage(ECommerceConstants.STORE_REGISTERED);
			storeResponseDto.setStatusCode(201);
			
		}else
			throw new InvalidStoreException(ECommerceConstants.STORE_ALREADY_REGISTERED);
		return storeResponseDto;
	}

}
