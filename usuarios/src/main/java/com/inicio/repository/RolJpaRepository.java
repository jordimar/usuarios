package com.inicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inicio.models.Rol;

public interface RolJpaRepository extends JpaRepository<Rol, String> {

}
