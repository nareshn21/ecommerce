package com.hcl.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.dto.UserResponseDto;
import com.hcl.ecommerce.dto.UserReviewDto;
import com.hcl.ecommerce.dto.UserReviewResponseDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.entity.UserReview;
import com.hcl.ecommerce.exception.InvalidStoreException;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.repository.UserRepository;
import com.hcl.ecommerce.repository.UserReviewRepository;
import com.hcl.ecommerce.util.ECommerceConstants;
/**
 * @author Naresh
 * @Description
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserReviewRepository userReviewRepository;
	@Autowired
	StoreRepository storeRepository;
	/**@Description
	 *
	 */
	@Override
	public UserResponseDto userRegister(UserDto userDto) throws UserNotFoundException {
		UserResponseDto userResponseDto=null;
		Optional<User> user=userRepository.findByMobileNo(userDto.getMobileNo());
		if(!user.isPresent()) {
			userResponseDto=new UserResponseDto();
			User users=new User();
			BeanUtils.copyProperties(userDto, users);
			userRepository.save(users);
			userResponseDto.setMessage(ECommerceConstants.REGISTERED);
			userResponseDto.setStatusCode(201);
		
		}else 
			throw new UserNotFoundException(ECommerceConstants.USER_ALREADY_REGISTERED);
		return userResponseDto;
	}
	/**@Description
	 *
	 */
	@Override
	public UserResponseDto userLogin(UserLoginDto userLoginDto) throws UserNotFoundException {
		UserResponseDto userResponseDto=null;
		Optional<User> user=userRepository.findByMobileNo(userLoginDto.getMobileNo());
		if(user.isPresent()) {
			if(user.get().getMobileNo().equals(userLoginDto.getMobileNo()) && user.get().getPassword().equals(userLoginDto.getPassword())) {
				userResponseDto=new UserResponseDto();
				userResponseDto.setMessage(ECommerceConstants.SUCCESSS);
				userResponseDto.setStatusCode(201);
				return userResponseDto;
			}else
				throw new UserNotFoundException(ECommerceConstants.LOGIN_FAILURE);
		}else 
			throw new UserNotFoundException(ECommerceConstants.NOT_FOUND);
		
	}
	/**@Description
	 *
	 */
	@Override
	public UserReviewResponseDto userReview(UserReviewDto userReviewDto) throws UserNotFoundException, InvalidStoreException {
		UserReviewResponseDto userReviewResponseDto=null;
		Optional<User> users=userRepository.findByUserId(userReviewDto.getUserId());
		if(users.isPresent()) {
			Optional<Store> stores=storeRepository.findByStoreName(userReviewDto.getStoreName());
			if(stores.isPresent()) {
			userReviewResponseDto	=new UserReviewResponseDto();
		UserReview review=new UserReview();	
		BeanUtils.copyProperties(userReviewDto, review);
		review.setStoreId(stores.get().getStoreId());
		userReviewRepository.save(review);
		userReviewResponseDto.setMessage("your review has been taken successfully");
		userReviewResponseDto.setStatusCode(201);
		return userReviewResponseDto;
			}else
				throw new InvalidStoreException(ECommerceConstants.STORE_NOT_FOUND);
		}else
			throw new UserNotFoundException(ECommerceConstants.REVIEW_NOT_FOUND);
		
	}

}
