package com.vigorride.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.commons.constants.VigorRideConstants;
import com.vigorride.signup.data.SignUpPayload;
import com.vigorride.signup.service.SignUpService;

import jakarta.validation.Valid;



@RestController
@RequestMapping(VigorRideConstants.VIGORRIDE_BASE_URL) 
public class SignUpController {

	@Autowired
	private SignUpService signUpService;
	
	
	
	@PostMapping("/signup")
	public void signUp(@Valid @RequestBody SignUpPayload signUpPayload) {
		signUpService.signUp(signUpPayload);
	}
	
	
	
}
