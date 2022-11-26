package com.exemple.location.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemple.location.dto.UserDTO;
import com.exemple.location.entities.UserEntity;
import com.exemple.location.helper.ModelMapperConverter;
import com.exemple.location.repository.UserRepository;
import com.exemple.location.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	/*
	 * method to find all users
	 */
	@Override
	public List<UserDTO> findAllUsers() {
		
		return modelMapperConverter.convertAllToDTO(userRepository.findAll(), UserDTO.class);
	}
	/*
	 * method to add a user
	 */
	@Override
	public void addUser(UserDTO user) {
		userRepository.save(modelMapperConverter.converToEntity(user, UserEntity.class));
	}
	@Override
	public List<UserEntity> getAllManagers() {
		
		return userRepository.findAllManager();
	}

}
