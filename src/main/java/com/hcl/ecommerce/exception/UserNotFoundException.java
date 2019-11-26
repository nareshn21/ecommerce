package com.hcl.ecommerce.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public UserNotFoundException(String message) {
		super(message);
	}

}
