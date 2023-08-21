package com.vigorride.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.entity.User;
import com.vigorride.repositoryWrapper.UserRepositoryWrapper;
import com.vigorride.service.AuthService;
import com.vigorride.service.JwtService;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private UserRepositoryWrapper userRepositoryWrapper;
	
	@Autowired
	private JwtService jwtService;
	

	@Override
	public String login(String username) {
		Optional<User> user=this.userRepositoryWrapper.findUserByName(username);
		if(user.isPresent()&&user.get().getPassword().equals(username)) {
			return this.jwtService.createJwtToken(username);
		
		return null;
	}

}
