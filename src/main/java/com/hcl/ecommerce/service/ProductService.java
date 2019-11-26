package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.dto.ProductResponseDto;
import com.hcl.ecommerce.dto.SearchProductDto;
import com.hcl.ecommerce.dto.SearchProductResponseDto;
import com.hcl.ecommerce.exception.InvalidProductException;
import com.hcl.ecommerce.exception.InvalidStoreException;

/**
 * @author Naresh
 * @Description
 *
 */
public interface ProductService {
	
	ProductResponseDto registerProduct(ProductDto productDto) throws InvalidProductException;
	List<SearchProductResponseDto> searchByProductName(SearchProductDto productsDto) throws InvalidProductException, InvalidStoreException;
}
