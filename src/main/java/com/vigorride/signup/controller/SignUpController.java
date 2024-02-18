package com.vigorride.signup.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vigorride.commons.constants.VigorRideConstants;
import com.vigorride.service.InvoiceSequenceGeneratorService;
import com.vigorride.signup.data.SignUpPayload;
import com.vigorride.signup.service.SignUpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(VigorRideConstants.VIGORRIDE_BASE_URL)
public class SignUpController {

	@Autowired
	private SignUpService signUpService;
	@Autowired
	private InvoiceSequenceGeneratorService invoiceSequenceGeneratorService;

	@PostMapping("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> signUp(@Valid @RequestBody SignUpPayload signUpPayload) {
		try {
			signUpService.signUp(signUpPayload);
			return ResponseEntity.ok("Successful");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error during signup");
		}
	}

}
