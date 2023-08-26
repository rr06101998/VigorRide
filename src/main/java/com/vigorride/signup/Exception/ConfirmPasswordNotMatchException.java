package com.vigorride.signup.Exception;

import com.vigorride.globals.VigorBadRequestException;

public class ConfirmPasswordNotMatchException extends  VigorBadRequestException {

	private static final long serialVersionUID = 1L;

	public ConfirmPasswordNotMatchException(String password) {
		super("Please make sure your passwords match.");
	}
}
