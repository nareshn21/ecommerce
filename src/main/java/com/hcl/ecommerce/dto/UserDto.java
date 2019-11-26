package com.hcl.ecommerce.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class UserDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private Long mobileNo;
	private String userLocation;
	
}
