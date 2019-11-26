package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.dto.ProductResponseDto;
import com.hcl.ecommerce.dto.SearchProductDto;
import com.hcl.ecommerce.dto.SearchProductResponseDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.entity.UserReview;
import com.hcl.ecommerce.exception.InvalidProductException;
import com.hcl.ecommerce.exception.InvalidStoreException;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.repository.UserReviewRepository;
import com.hcl.ecommerce.util.ECommerceConstants;

/**
 * @author Naresh
 * @Description
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	StoreRepository storeRepository;
	@Autowired
	UserReviewRepository userReviewRepository;

	/**@Description
	 * 
	 *
	 */
	@Override
	public ProductResponseDto registerProduct(ProductDto productDto) throws InvalidProductException {
		ProductResponseDto productResponseDto = null;
		Optional<Product> product = productRepository.findByBrandName(productDto.getBrandName());
		if (!product.isPresent()) {
			productResponseDto = new ProductResponseDto();
			Product products = new Product();
			BeanUtils.copyProperties(productDto, products);
			productRepository.save(products);
			productResponseDto.setMessage(ECommerceConstants.PRODCUT_REGISTRED);
			productResponseDto.setStatusCode(200);

		} else {
			throw new InvalidProductException(ECommerceConstants.PRODUCT_ALREADY_REGISTERED);
		}
		return productResponseDto;

	}

	/**@Description
	 *
	 */
	@Override
	public List<SearchProductResponseDto> searchByProductName(SearchProductDto productsDto)
			throws InvalidProductException, InvalidStoreException {
		SearchProductResponseDto productsResponseDto = null;
		List<Product> products = productRepository.findByProductNameStartsWith(productsDto.getProductName());
		List<SearchProductResponseDto> productDtos = new ArrayList<>();
		if (products != null) {
			for (Product product : products) {
				
				List<Store> stores = storeRepository.findByProductId(product.getProductId());
				if (stores != null) {
					for (Store store : stores) {
						productsResponseDto = new SearchProductResponseDto();
						BeanUtils.copyProperties(store, productsResponseDto);
						productsResponseDto.setProductName(product.getProductName());
						productsResponseDto.setBrandName(product.getBrandName());
						productsResponseDto.setProductPrice(product.getProductPrice());
						float savings=(float) (product.getProductPrice()*store.getProductDiscount()/100);
						productsResponseDto.setSavings(savings);
						double price=product.getProductPrice()-savings;
						productsResponseDto.setFinalProductPrice(price);
						Optional<UserReview> review=userReviewRepository.findByStoreId(store.getStoreId());
						if(review.isPresent()) {
							Integer avgReview=review.get().getReview()/2;
							productsResponseDto.setStoreReview(avgReview);
					}
						productDtos.add(productsResponseDto);
					}

				} else
					throw new InvalidStoreException(ECommerceConstants.PRODUCT_NOT_FOUND);

			}
			return productDtos;
		} else
			throw new InvalidProductException(ECommerceConstants.PRODUCT_NOT_FOUND);
	}

}
