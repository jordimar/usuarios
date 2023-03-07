package com.inicio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inicio.models.User;


public interface UserJpaRepository extends JpaRepository<User, String> {

	
//	@Query("SELECT u FROM User u JOIN Rol r ON u.username = r.username")
//	@Query("SELECT u FROM User")
//	List<com.inicio.models.User> findUserAndRol();
}
