package com.vigorride.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.entity.User;
import com.vigorride.request.LoginPayload;
import com.vigorride.service.EmployeeService;
import com.vigorride.service.LoginService;

import jakarta.validation.Valid;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	
	@PostMapping("/login")
	public Boolean LoginUser(@Valid @RequestBody LoginPayload loginPayload) {
		 return loginService.login(loginPayload);
	}
	
	
	
}
