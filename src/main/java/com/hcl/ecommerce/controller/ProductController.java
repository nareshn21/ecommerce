package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.dto.ProductResponseDto;
import com.hcl.ecommerce.dto.SearchProductDto;
import com.hcl.ecommerce.dto.SearchProductResponseDto;
import com.hcl.ecommerce.exception.InvalidProductException;
import com.hcl.ecommerce.exception.InvalidStoreException;
import com.hcl.ecommerce.service.ProductService;

/**
 * @author Naresh
 * @Description this product controller is managed the product related services and operations
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	/**
	 * @Description 
	 * @param productDto
	 * @return
	 * @throws InvalidProductException
	 */
	@PostMapping("")
	public ProductResponseDto registerProduct(ProductDto productDto) throws InvalidProductException{
		ProductResponseDto productResponseDto=productService.registerProduct(productDto);
		return productResponseDto;
	}
	/**
	 * @Description
	 * @param searchproductsDto
	 * @return
	 * @throws InvalidProductException
	 * @throws InvalidStoreException
	 */
	@GetMapping("/productName")
	public List<SearchProductResponseDto> searchByProductName(SearchProductDto searchproductsDto) throws InvalidProductException, InvalidStoreException{
		List<SearchProductResponseDto> ProductsResponseDto=productService.searchByProductName(searchproductsDto);
		return ProductsResponseDto;
	}
}
