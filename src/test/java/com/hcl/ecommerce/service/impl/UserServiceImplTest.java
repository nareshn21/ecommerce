package com.hcl.ecommerce.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.dto.UserLoginDto;
import com.hcl.ecommerce.dto.UserResponseDto;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.repository.UserRepository;
import com.hcl.ecommerce.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {
	@InjectMocks
	UserServiceImpl userServiceImpl;
	@Mock
	UserRepository 	userRepository;
	UserResponseDto userResponseDto;
	UserDto userDto;
	User userRegister;
	UserLoginDto userLoginDto;
	public UserResponseDto getUserRegisterResponseDto() {
		UserResponseDto userResponseDto=new UserResponseDto();
		userResponseDto.setMessage("user register successfully");
		userResponseDto.setStatusCode(201);
		return userResponseDto;
	}
	public UserDto getUserRegisterDto() {
		UserDto userDto=new UserDto();
		userDto.setUserName("user1");
		userDto.setPassword("user1@123");
		userDto.setMobileNo(9916438755L);
		userDto.setUserLocation("Bangalore");
		return userDto;
	}
	User getRegister() {
		User userRegister=new User();
		userRegister.setUserId(1);
		userRegister.setUserName("user1");
		userRegister.setPassword("user1@123");
		userRegister.setMobileNo(9916438755L);
		userRegister.setUserLocation("Bangalore");
		return userRegister;
		
	}
	public UserLoginDto getUserLoginDto(){
		UserLoginDto userLoginDto=new UserLoginDto();
		userLoginDto.setMobileNo(9916438755L);
		userLoginDto.setPassword("user1@123");
		return userLoginDto;
	}
	@Before
	public void setup()
	{
		userRegister=getRegister();
		userResponseDto = getUserRegisterResponseDto();
		userDto = getUserRegisterDto();
		userLoginDto=getUserLoginDto();
	}
	
	@Test
	public void testUserRegister() throws UserNotFoundException {
		Mockito.when(userRepository.save(Mockito.any())).thenReturn(userRegister);
		UserResponseDto response=userServiceImpl.userRegister(userDto);
		assertEquals("User registered successfully", response.getMessage());
		
	}
	
	  @Test public void testUserLogin()throws UserNotFoundException {
	  Optional<User> user =Optional.of(userRegister);
	  
	  Mockito.when(userRepository.findByMobileNo(9916438755L)).thenReturn(user);
	  
	  }
	 
}
