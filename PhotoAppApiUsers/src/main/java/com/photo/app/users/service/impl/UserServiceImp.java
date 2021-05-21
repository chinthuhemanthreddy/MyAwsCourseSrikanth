package com.photo.app.users.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.photo.app.users.api.data.AlbumsServiceClient;
import com.photo.app.users.api.data.UserEntity;
import com.photo.app.users.model.AlbumResponseModel;
import com.photo.app.users.repository.UserRepository;
import com.photo.app.users.service.UserService;
import com.photo.app.users.shared.UserDto;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImp implements UserService {
	
	UserRepository userRepository;
	
    RestTemplate restTemplate;
	
    AlbumsServiceClient albumsServiceClient;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
		
	Environment environment;
	@Autowired
	public UserServiceImp(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder
			, RestTemplate restTemplate, Environment environment, AlbumsServiceClient albumsServiceClient) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.restTemplate = restTemplate;
		this.environment=environment;
		this.albumsServiceClient =albumsServiceClient;
	}

	@Override
	public UserDto createUser(UserDto userdetails) {
		// TODO Auto-generated method stub
		userdetails.setUserId(UUID.randomUUID().toString());
		userdetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userdetails.getPassword()));
		ModelMapper mapper = new ModelMapper();
		userdetails.setUserId("1");
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity entity =mapper.map(userdetails, UserEntity.class);
		
		userRepository.save(entity);
		
		UserDto returnValue = mapper.map(entity, UserDto.class);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity entity = userRepository.findByEmail(username);
		if(entity == null) throw new UsernameNotFoundException(username);
		return new User(entity.getEmail(),entity.getEncryptedPassword(), true, true,true,true,new ArrayList<>());
	}

	@Override
	public UserDto getUserByUsername(String username) {
		UserEntity entity  = userRepository.findByEmail(username);
		if(entity == null) throw new UsernameNotFoundException(username);
		return new ModelMapper().map(entity, UserDto.class);
	}

	@Override
	public UserDto getUserbyId(String userId) {
		
		UserEntity entity  = userRepository.findByEmail(userId);
		if(entity == null) throw new UsernameNotFoundException("User not found "+userId);
		UserDto dto = new  ModelMapper().map(entity, UserDto.class);
		
		String albumsurl = String.format(environment.getProperty("albums.url"), userId);
		
		 ResponseEntity<List<AlbumResponseModel>> response = restTemplate.exchange(albumsurl, HttpMethod.GET, null,new ParameterizedTypeReference<List<AlbumResponseModel>>() {
	        });
	        List<AlbumResponseModel> albumList = response.getBody();
	        
	        dto.setListAlbums(albumList);
		return dto;
	}
	//calling web service using Feign Client
	@Override
	public UserDto getUserbyIdbyFeignTempate(String userId) {
		
		UserEntity entity  = userRepository.findByEmail(userId);
		if(entity == null) throw new UsernameNotFoundException("User not found "+userId);
		UserDto dto = new  ModelMapper().map(entity, UserDto.class);
		List<AlbumResponseModel> albumList = null;
		//try {
		log.info("Zipkin -> before calling the albums microservice ::: ");
		albumList = albumsServiceClient.getAlbums(userId);
		log.info("Zipkin -> after calling the albums microservice ::: "+albumList);
		/*}catch(FeignException e) {
			System.out.println("feign exception in service class..."+e.getMessage());
		}*/
		 dto.setListAlbums(albumList);
		 
		 System.out.println("Feign Client response:::: "+dto);
		return dto;
	}
	

}
