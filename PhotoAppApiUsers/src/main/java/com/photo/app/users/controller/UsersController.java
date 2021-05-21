package com.photo.app.users.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photo.app.users.model.UserResponseModel;
import com.photo.app.users.service.UserService;
import com.photo.app.users.shared.UserDto;
import com.photo.app.users.ui.model.CreateUserRequestModel;
import com.photo.app.users.ui.model.CreateUserResponseModel;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/status/check")
public String status() {
	return "Working with port number ::: "+env.getProperty("local.server.port");
	
}

/*
 * @PostMapping(path = "/create", consumes = {MediaType.APPLICATION_XML_VALUE,
 * MediaType.APPLICATION_JSON_VALUE} , produces =
 * {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
 */
	@PostMapping("/create")
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userdetails) {
		System.out.println("userdetails :::: "+userdetails);
				
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto dto =mapper.map(userdetails, UserDto.class);
		UserDto createValue= userservice.createUser(dto);
		CreateUserResponseModel createUserResponseModel= mapper.map(createValue,CreateUserResponseModel.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(createUserResponseModel);
	}
	
	@GetMapping(value="/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserResponseModel> getUserDetails(@PathVariable String userId) {
		
		UserDto userDto = userservice.getUserbyId(userId);
		UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
	@GetMapping(value="/feign/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<UserResponseModel> getUserDetailsByFeign(@PathVariable String userId) {
		
		UserDto userDto = userservice.getUserbyIdbyFeignTempate(userId);
		UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
	
}
