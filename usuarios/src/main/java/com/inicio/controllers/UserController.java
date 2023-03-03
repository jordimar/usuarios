package com.inicio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inicio.models.User;
import com.inicio.service.UserServiceImpl;

@RestController
@RequestMapping("/users/v1")
public class UserController {
	
	@Autowired
	UserServiceImpl service;
	
	@PostMapping("/alta")
	ResponseEntity<?> alta(@RequestBody User user){
		
		service.altaUser(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
