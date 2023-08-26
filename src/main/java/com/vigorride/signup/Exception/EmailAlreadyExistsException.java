package com.vigorride.signup.Exception;

import com.vigorride.globals.VigorBadRequestException;

public class EmailAlreadyExistsException extends  VigorBadRequestException {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException(String emailId) {
		super("Email with email id "+emailId+" already exists.");
	}
}
