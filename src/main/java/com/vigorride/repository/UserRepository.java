package com.vigorride.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByEmail(String email);

	Optional<User> findByUserName(String username);

}
