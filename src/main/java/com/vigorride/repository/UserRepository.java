package com.vigorride.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vigorride.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByEmailOrUserName(final String email,final String username);

	Optional<User> findByUserName(final String username);

    Optional<User> findByEmailOrUserNameOrMobileNo(String email, String userName, Long mobileNo);

}
