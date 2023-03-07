package com.inicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.inicio.models.Rol;
import com.inicio.repository.RolJpaRepository;
import com.inicio.repository.UserJpaRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsManager userDetailsManager;
	
	@Autowired
	UserJpaRepository repo;
	
	@Autowired
	RolJpaRepository repoRol;
	
	
	public void altaUser(com.inicio.models.UserDto usuario) {
		
		UserDetails user = User.withUsername(usuario.getUsername()).password(passwordEncoder.encode(usuario.getPassword())).authorities(usuario.getRol()).build();
		userDetailsManager.createUser(user);
		
	}
	
	public void modifUser(com.inicio.models.UserDto usuario) {
		
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



	@Override
	public List<com.inicio.models.User> getUsuariosyroles() {
		 
		return repo.findAll();
	}

	@Override
	public List<Rol> getRolesyUsuarios() {
		 
		return repoRol.findAll();
	}
}
