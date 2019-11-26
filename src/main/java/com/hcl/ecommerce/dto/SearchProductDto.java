package com.hcl.ecommerce.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@NoArgsConstructor
public class SearchProductDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String productName;

}
