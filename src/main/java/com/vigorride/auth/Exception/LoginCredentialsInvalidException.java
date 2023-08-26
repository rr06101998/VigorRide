package com.vigorride.auth.Exception;

import com.vigorride.globals.VigorBadRequestException;

public class LoginCredentialsInvalidException extends  VigorBadRequestException {


	private static final long serialVersionUID = 1L;

	public LoginCredentialsInvalidException() {
		super("Login credentials are invalid ,Please enter valid details.");
	}
}
