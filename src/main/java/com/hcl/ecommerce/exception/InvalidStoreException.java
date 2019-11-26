package com.hcl.ecommerce.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InvalidStoreException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	public InvalidStoreException(String message) {
		super(message);
	}

}


