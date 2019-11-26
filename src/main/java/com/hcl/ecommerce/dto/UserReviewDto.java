package com.hcl.ecommerce.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserReviewDto implements Serializable {
	private static final long serialVersionUID = 1L; 

	private Integer userId;
	private String storeName;
	private Integer review;
	
}
