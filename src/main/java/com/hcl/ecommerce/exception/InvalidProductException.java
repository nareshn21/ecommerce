package com.hcl.ecommerce.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InvalidProductException extends Exception{
	private static final long serialVersionUID = 1L;
	private String message;
	public InvalidProductException(String message) {
		super(message);
	}

}
