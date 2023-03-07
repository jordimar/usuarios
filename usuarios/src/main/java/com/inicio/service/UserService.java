package com.inicio.service;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.inicio.models.UserDto;

public interface UserService {
	
	public void altaUser(com.inicio.models.UserDto usuario);
	
	public void modifUser(com.inicio.models.UserDto usuario) ;
	
	public void borraUser(String username) ;
	
	public boolean ifExist(String usuario) ;
	
	public UserDetails getUser(String username);
	
	public List<com.inicio.models.User>  getUsuariosyroles();
	
	public List<com.inicio.models.Rol>  getRolesyUsuarios();

}
