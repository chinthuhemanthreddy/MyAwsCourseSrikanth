package com.photo.app.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.photo.app.users.api.data.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	

	UserEntity findByFirstName(String username);

	UserEntity findByEmail(String username);

}
