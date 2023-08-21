package com.vigorride.exception;

public class UserNotAgreedConditionException extends AbstractPlatformResourceNotFoundException{

	private static final long serialVersionUID = 1L;

	public UserNotAgreedConditionException() {
		// TODO Auto-generated constructor stub
		super(null, "Please make sure you agree with Conditions", null);

	}
}
	
