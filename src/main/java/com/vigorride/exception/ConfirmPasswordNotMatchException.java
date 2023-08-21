package com.vigorride.exception;

public class ConfirmPasswordNotMatchException extends  AbstractPlatformResourceNotFoundException {

	private static final long serialVersionUID = 1L;

	public ConfirmPasswordNotMatchException(String password) {
		super("redeemio.exception.password.not.match","Please make sure your passwords match",password);
	}
}
