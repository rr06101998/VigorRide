package com.vigorride.exception;

public class LoginCredentialsInvalidException extends  AbstractPlatformResourceNotFoundException {


	private static final long serialVersionUID = 1L;

	public LoginCredentialsInvalidException() {
		super("redeemio.exception.login.credentials.invalid","Login credentials are invalid ,Please enter valid details.",null);
	}
}
