package com.vigorride.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.auth.Exception.LoginCredentialsInvalidException;
import com.vigorride.auth.data.AuthPayload;
import com.vigorride.entity.User;
import com.vigorride.repository.UserRepositoryWrapper;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private UserRepositoryWrapper userRepositoryWrapper;
	
	@Autowired
	private JwtService jwtService;
	

	@Override
	public String login(final AuthPayload authPayload) {
		Optional<User> user=this.userRepositoryWrapper.findByEmailOrUserName(authPayload.getUsername(),authPayload.getUsername());
		if(!user.isPresent()||!user.get().getPassword().equals(authPayload.getPassword())) {
			throw new LoginCredentialsInvalidException();
			
		}
		return this.jwtService.createJwtToken(authPayload.getUsername());
		
	}

}
