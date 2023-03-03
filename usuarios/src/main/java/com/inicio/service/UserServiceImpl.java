package com.inicio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;


@Service
public class UserServiceImpl {
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsManager userDetailsManager;
	
	
	public void altaUser(com.inicio.models.User usuario) {
		
		UserDetails user = User.withUsername(usuario.getUsername()).password(passwordEncoder.encode(usuario.getPassword())).authorities(usuario.getRol()).build();
		userDetailsManager.createUser(user);
		
	}
	
	public void modifUser(com.inicio.models.User usuario) {
		
		UserDetails user = User.withUsername(usuario.getUsername()).password(passwordEncoder.encode(usuario.getPassword())).authorities(usuario.getRol()).build();
		userDetailsManager.updateUser(user);
		
	}
	
	public void borraUser(String username) {
		
		userDetailsManager.deleteUser(username);;;
	}
	
	public boolean ifExist(String usuario) {
		
		
		return userDetailsManager.userExists(usuario);
	}
	
	public UserDetails getUser(String username) {
		
		return userDetailsManager.loadUserByUsername(username);
	}
}
