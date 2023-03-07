package com.inicio.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="authorities")
public class Rol {

	@Id
	private String username;
	
	@Column(name="authority")	
	private String rol;
	
//	@OneToOne
//	@JoinColumn(name="username")
//	@MapsId
//    private User user;
	
	public Rol() {}
	
	

	public Rol(String username, String rol) {
		super();
		this.username = username;
		this.rol = rol;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

//	@JsonBackReference
//	@JsonManagedReference
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}




}
