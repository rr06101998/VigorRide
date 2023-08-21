package com.vigorride.repositoryWrapper;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.entity.User;
import com.vigorride.repository.UserRepository;

@Service
public class UserRepositoryWrapper {
	
    @Autowired
	private UserRepository userRepository;

	public Optional<User> findUserByName(String username) {
	 
		return this.userRepository.findByUserName(username);
		 
  
	}

}
