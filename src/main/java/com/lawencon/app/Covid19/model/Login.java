package com.lawencon.app.Covid19.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLogin;
	private String username, password;
	public int getIdLogin() {
		return idLogin;
	}
	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}