package com.TLCN_BOOKING.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Entity(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username", nullable = false)
	private String username;
	
	@Column(name="email", nullable = false)
	private String email;
	
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="active", nullable = false)
	private Integer active;
	
	@Column(name="roleuserid", nullable = false)
	private Integer roleuserid;
	
	
	public User() {
		
	}
	
	public User(String username, String email, String password, Integer active, Integer roleuserid) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
		this.roleuserid = roleuserid;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public int getRoleuserid() {
		return roleuserid;
	}

	public void setRoleuserid(Integer roleuserid) {
		this.roleuserid = roleuserid;
	}



}
