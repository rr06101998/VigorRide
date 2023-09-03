package com.vigorride.signup.Exception;

import com.vigorride.globals.VigorBadRequestException;

public class MobileNoAlreadyExistException extends  VigorBadRequestException {

	private static final long serialVersionUID = 1L;

	public MobileNoAlreadyExistException(Long mobileNo) {
		super("Mobile No "+mobileNo+" already registered.");
	}
}
