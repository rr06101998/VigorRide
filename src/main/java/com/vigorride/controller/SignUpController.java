package com.vigorride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.request.SignUpPayload;
import com.vigorride.service.LoginService;

import jakarta.validation.Valid;



@RestController
public class SignUpController {

	@Autowired
	private LoginService loginService;
	
	
	
	@PostMapping("/signup")
	public void signUp(@Valid @RequestBody SignUpPayload signUpPayload) {
		 loginService.signUp(signUpPayload);
	}
	
	
	
}
