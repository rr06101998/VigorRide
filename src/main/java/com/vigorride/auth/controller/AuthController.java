package com.vigorride.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.auth.data.AuthPayload;
import com.vigorride.auth.service.AuthService;
import com.vigorride.commons.constants.VigorRideConstants;

import jakarta.validation.Valid;

@RestController
@RequestMapping(VigorRideConstants.VIGORRIDE_BASE_URL) 
public class AuthController {

	@Autowired
	private AuthService authService;
		
	
	@PostMapping("/auth")
	public String login(@Valid @RequestBody AuthPayload authPayload) {
		return authService.login(authPayload);
	}
	
	
	
}
