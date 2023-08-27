package com.vigorride.resetPassword.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.commons.constants.VigorRideConstants;
import com.vigorride.resetPassword.data.ResetPasswordPayload;
import com.vigorride.resetPassword.service.ResetPasswordService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(VigorRideConstants.VIGORRIDE_BASE_URL)
public class PasswordResetController {

	@Autowired
	private ResetPasswordService resetPasswordService;

    @PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/resetpassword")
	public void signUp(@Valid @RequestBody ResetPasswordPayload resetPasswordPayload) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("User Roles: " + auth.getAuthorities());

		resetPasswordService.resetPassword(resetPasswordPayload);
	}

}
