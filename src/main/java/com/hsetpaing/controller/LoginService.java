package com.hsetpaing.controller;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateUser(String name, String password) {
		return name.equalsIgnoreCase("hsetpaing") && password.equals("hsetpaing");
	}
}
