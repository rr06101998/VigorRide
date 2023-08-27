package com.vigorride.signup.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vigorride.commons.vault.EncryptionService;
import com.vigorride.entity.User;
import com.vigorride.repository.UserRepositoryWrapper;
import com.vigorride.signup.Exception.ConfirmPasswordNotMatchException;
import com.vigorride.signup.Exception.EmailAlreadyExistsException;
import com.vigorride.signup.Exception.MobileNoAlreadyExistException;
import com.vigorride.signup.Exception.UserNameAlreadyExistsException;
import com.vigorride.signup.data.SignUpPayload;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

	private final UserRepositoryWrapper userRepositoryWrapper;
	private final EncryptionService encryptionService;

	@Override
	public void signUp(SignUpPayload signUpPayload) {
		try {
			signUpPayload.setPassword(this.encryptionService.encrypt(signUpPayload.getPassword()));
			signUpPayload.setConfirmPassword(this.encryptionService.encrypt(signUpPayload.getConfirmPassword()));
		} catch (Exception e) {
			e.printStackTrace();
		}
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

		Optional<User> user =userRepositoryWrapper.findByEmailOrUserNameOrMobileNo(signUpPayload.getEmail(), signUpPayload.getUserName(),signUpPayload.getMobileNo());

		if(user.isPresent()){
			if(user.get().getEmail().equals(signUpPayload.getEmail())){
				throw new EmailAlreadyExistsException(signUpPayload.getEmail());
			}
			if(user.get().getMobileNo().equals(signUpPayload.getMobileNo())){
				throw new MobileNoAlreadyExistException(signUpPayload.getMobileNo());
			}
			if(user.get().getUserName().equals(signUpPayload.getUserName()))
			throw new UserNameAlreadyExistsException(signUpPayload.getUserName());
		}


	}

}
