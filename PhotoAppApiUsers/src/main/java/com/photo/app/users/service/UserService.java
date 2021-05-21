package com.photo.app.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.photo.app.users.shared.UserDto;

public interface UserService extends UserDetailsService{

	UserDto createUser(UserDto userdetails);
	UserDto getUserByUsername(String username);
	UserDto getUserbyId(String userId);
	UserDto getUserbyIdbyFeignTempate(String userId);
}
