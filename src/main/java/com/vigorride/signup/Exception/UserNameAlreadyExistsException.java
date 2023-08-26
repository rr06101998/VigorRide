package com.vigorride.signup.Exception;

import com.vigorride.globals.VigorBadRequestException;

public class UserNameAlreadyExistsException extends  VigorBadRequestException {

	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistsException(String username) {
		super("Username "+username+" already taken.");
	}
}
