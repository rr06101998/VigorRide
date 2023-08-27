package com.vigorride.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.auth.Exception.LoginCredentialsInvalidException;
import com.vigorride.auth.data.AuthPayload;
import com.vigorride.commons.vault.EncryptionService;
import com.vigorride.entity.User;
import com.vigorride.repository.UserRepositoryWrapper;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private UserRepositoryWrapper userRepositoryWrapper;
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private EncryptionService encryptionService;
	

	@Override
	public String login(final AuthPayload authPayload) {
		try {
			authPayload.setPassword(this.encryptionService.encrypt(authPayload.getPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Optional<User> user=this.userRepositoryWrapper.findByEmailOrUserName(authPayload.getUsername(),authPayload.getUsername());
		if(!user.isPresent()||!user.get().getPassword().equals(authPayload.getPassword())) {
			throw new LoginCredentialsInvalidException();
			
		}
		return this.jwtService.createJwtToken(authPayload.getUsername());
		
	}

}
