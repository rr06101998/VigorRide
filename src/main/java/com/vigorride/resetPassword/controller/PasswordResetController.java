package com.vigorride.resetPassword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.constants.VigorRideConstants;
import com.vigorride.resetPassword.data.ResetPasswordPayload;
import com.vigorride.resetPassword.service.ResetPasswordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(VigorRideConstants.VIGORRIDE_BASE_URL)
public class PasswordResetController {

	@Autowired
	private ResetPasswordService resetPasswordService;

	@PostMapping("/resetpassword")
	public void signUp(@Valid @RequestBody ResetPasswordPayload resetPasswordPayload) {
		resetPasswordService.resetPassword(resetPasswordPayload);
	}

}
