package com.exemple.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemple.location.config.JwtTokenProvider;
import com.exemple.location.dto.AuthenticateDTO;
import com.exemple.location.dto.UserDTO;
import com.exemple.location.entities.UserEntity;
import com.exemple.location.repository.UserRepository;
import com.exemple.location.serviceImpl.CustomUserDetailsService;





@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

	@Autowired
	private CustomUserDetailsService userService;

	/*
	 * login authentication
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public AuthenticateDTO login(@RequestBody AuthBody data) {
		AuthenticateDTO auth = new AuthenticateDTO();
		auth.setIsauthnenticate(false);
		try {
			String username = data.getEmail();

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
			String token = jwtTokenProvider.createToken(username, this.userRepository.findByEmail(username).getRoles());

			auth.setToken(token);
			auth.setUsername(username);
			auth.setIsauthnenticate(true);
			UserEntity user = this.userRepository.findByEmail(username);
			UserDTO userDto = new UserDTO();
			// chqrgrment data
			userDto.setFirstName(user.getFirstName());
			userDto.setRoles(user.getRoles());
			userDto.setAddresse(user.getAddresse());
			userDto.setLastName(user.getLastName());
			userDto.setTelephone(user.getTelephone());
			userDto.setUsername(user.getUsername());
			userDto.setPassword(user.getPassword());
			userDto.setEmail(user.getEmail());
			auth.setUser(userDto);
			auth.setMessage("ok");
			System.out.println("\n\n\nauth"+auth.getToken());
			return auth;

		} catch (AuthenticationException e) {
             System.out.println("\n\n\nerreur de connexion");
			return auth;
		}

	}

	/*
	 * register authentication
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/register")
	public Boolean register(@RequestBody UserEntity user) {
		System.out.println(user);
		UserEntity userExists = userService.findUserByLogin(user.getEmail());
		if (userExists != null) {
			return false;
		}
		userService.saveUser(user);
		return true;
	}

}
