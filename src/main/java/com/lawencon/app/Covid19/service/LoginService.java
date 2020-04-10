package com.lawencon.app.Covid19.service;

import java.util.List;

import com.lawencon.app.Covid19.model.Login;

public interface LoginService {
	abstract List<Login> findAll() throws Exception;
	abstract Boolean validUser(String user, String pass) throws Exception;
	abstract String insertUser(Login login) throws Exception;
	abstract String update(int id, String user, String pass) throws Exception;
	abstract String deleteById(int id) throws Exception;
}
