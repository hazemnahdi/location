package com.exemple.location.service;

import java.util.List;

import com.exemple.location.dto.UserDTO;
import com.exemple.location.entities.UserEntity;



public interface UserService {
   public List<UserDTO> findAllUsers();
	
	public void addUser (UserDTO user);
	
	public List<UserEntity> getAllManagers();

}
