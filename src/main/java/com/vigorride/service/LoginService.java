package com.vigorride.service;

import com.vigorride.request.LoginPayload;
import com.vigorride.request.SignUpPayload;

public interface LoginService {
	
    public Boolean login(LoginPayload loginPayload);
    
	public void signUp(SignUpPayload signUpPayload);
	
}
