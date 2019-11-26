package com.hcl.ecommerce.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SearchProductResponseDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private String productName;
	private double productPrice;
	private String brandName;
	private String storeName;
	private float storeReview;
	private float savings;
	private double finalProductPrice;
}
