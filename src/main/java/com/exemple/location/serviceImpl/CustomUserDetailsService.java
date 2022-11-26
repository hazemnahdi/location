package com.exemple.location.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exemple.location.entities.RoleEntity;
import com.exemple.location.entities.UserEntity;
import com.exemple.location.repository.UserRepository;





@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	public UserEntity findUserByLogin(String email) {
	    return userRepository.findByEmail(email);
	}
	
	public UserEntity findUserByFirstName(String firstName) {
	    return userRepository.findByFirstName(firstName);
	}
	
	public void saveUser(UserEntity user) {
		user.setEnabled(true);
	    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	   
	    //user.setRoles(RoleEntity.ASSISTANT);
	   
	   userRepository.save(user);
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

	    UserEntity user = userRepository.findByEmail(login);
	    if(user != null) {
	        List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
	        return buildUserForAuthentication(user, authorities);
	    } else {
	        throw new UsernameNotFoundException("username not found");
	    }
	}
	
	private List<GrantedAuthority> getUserAuthority(RoleEntity userRoles) {
	    Set<GrantedAuthority> roles = new HashSet<>();
	        roles.add(new SimpleGrantedAuthority(userRoles+""));

	    List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
	    return grantedAuthorities;
	}
	
	private UserDetails buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
	    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
}
