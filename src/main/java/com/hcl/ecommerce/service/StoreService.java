package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.dto.StoreResponseDto;
import com.hcl.ecommerce.exception.InvalidStoreException;

public interface StoreService {
 StoreResponseDto storeRegister(StoreDto storeDto) throws InvalidStoreException;
}
