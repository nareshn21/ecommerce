package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.dto.UserResponseDto;
import com.hcl.ecommerce.dto.UserReviewDto;
import com.hcl.ecommerce.dto.UserReviewResponseDto;
import com.hcl.ecommerce.exception.InvalidStoreException;
import com.hcl.ecommerce.exception.UserNotFoundException;

public interface UserService {

	UserResponseDto userRegister(UserDto userDto) throws UserNotFoundException;
	
	UserResponseDto userLogin(UserLoginDto userLoginDto) throws UserNotFoundException;
	UserReviewResponseDto userReview(UserReviewDto userReviewDto) throws UserNotFoundException, InvalidStoreException;
}
