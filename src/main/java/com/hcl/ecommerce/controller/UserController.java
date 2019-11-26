package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.dto.UserResponseDto;
import com.hcl.ecommerce.dto.UserReviewDto;
import com.hcl.ecommerce.dto.UserReviewResponseDto;
import com.hcl.ecommerce.exception.InvalidStoreException;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.service.UserService;

/**
 * @author Naresh
 * @Description
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	/**
	 * @Description
	 * @param userDto
	 * @return
	 * @throws UserNotFoundException
	 */
	@PostMapping("")
	public UserResponseDto userRegister(UserDto userDto) throws UserNotFoundException {
		UserResponseDto userResponseDto=userService.userRegister(userDto);
	return userResponseDto;
	}
	/**
	 * @Description
	 * @param userLoginDto
	 * @return
	 * @throws UserNotFoundException
	 */
	@PostMapping("/login")
	public UserResponseDto login(UserLoginDto userLoginDto) throws UserNotFoundException{
		UserResponseDto userResponseDto=userService.userLogin(userLoginDto);
		return userResponseDto;
	}
	/**@Description
	 * @param userReviewDto
	 * @return
	 * @throws UserNotFoundException
	 * @throws InvalidStoreException
	 */
	@PostMapping("review")
	public UserReviewResponseDto userReview(UserReviewDto userReviewDto) throws UserNotFoundException, InvalidStoreException{
		UserReviewResponseDto 	userReviewResponseDto=userService.userReview(userReviewDto);
	return userReviewResponseDto;
	}

}
