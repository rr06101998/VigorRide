package com.vigorride.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.entity.User;
import com.vigorride.service.AuthService;
import com.vigorride.service.EmployeeService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;
		
	
	
	@PostMapping("/Auth/{username}")
	public String login(@PathVariable("username") String username) {
		 return authService.login(username);
	}
	
	
	
}
