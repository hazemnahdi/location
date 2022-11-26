package com.exemple.location.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exemple.location.entities.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
	UserEntity findByFirstName(String firstName);
	
	@Query("SELECT a FROM UserEntity a WHERE isManager = true")
	List<UserEntity> findAllManager();

}
