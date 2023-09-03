package com.vigorride.resetPassword.exception;

import com.vigorride.globals.VigorBadRequestException;

public class UserNotExistsException extends  VigorBadRequestException {

	private static final long serialVersionUID = 1L;

	public UserNotExistsException(String userName) {
		super("User not Exist with username "+userName+".");
	}
}
