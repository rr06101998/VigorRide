package com.vigorride.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vigorride.entity.User;

@Service
public class UserRepositoryWrapper {
	
    @Autowired
	private UserRepository userRepository;

	public Optional<User> findUserByName(final String username) {
		return this.userRepository.findByUserName(username);
	}

	public Optional<User> findByEmailOrUserName(final String email,final String username) {
		return this.userRepository.findByEmailOrUserName(email,username);
	}

	public void save(User user) {
		this.userRepository.save(user);

	}

}
