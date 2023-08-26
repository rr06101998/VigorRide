package com.vigorride.signup.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vigorride.entity.User;
import com.vigorride.repository.UserRepositoryWrapper;
import com.vigorride.signup.Exception.ConfirmPasswordNotMatchException;
import com.vigorride.signup.Exception.EmailAlreadyExistsException;
import com.vigorride.signup.Exception.UserNameAlreadyExistsException;
import com.vigorride.signup.data.SignUpPayload;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

	private final UserRepositoryWrapper userRepositoryWrapper;

	@Override
	public void signUp(SignUpPayload signUpPayload) {
		CheckValidation(signUpPayload);
		User user = User.builder().salutation(signUpPayload.getSalutation())
				.firstName(signUpPayload.getFirstName())
				.lastName(signUpPayload.getLastName())
				.email(signUpPayload.getEmail())
				.password(signUpPayload.getPassword())
				.dob(signUpPayload.getDob())
				.mobileNo(signUpPayload.getMobileNo())
				.userName(signUpPayload.getUserName())
				.build();
		userRepositoryWrapper.save(user);
	}

	public void CheckValidation(SignUpPayload signUpPayload) {
		if (!signUpPayload.getPassword().equals(signUpPayload.getConfirmPassword())) {
			throw new ConfirmPasswordNotMatchException(signUpPayload.getPassword());
		}

		Optional<User> user =userRepositoryWrapper.findByEmailOrUserName(signUpPayload.getEmail(), signUpPayload.getUserName());

		if(user.isPresent()){
			if(user.get().getEmail().equals(signUpPayload.getEmail())){
				throw new EmailAlreadyExistsException(signUpPayload.getEmail());
			}
			throw new UserNameAlreadyExistsException(signUpPayload.getUserName());

		}


	}

}
