package com.vigorride.resetPassword.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vigorride.commons.vault.EncryptionService;
import com.vigorride.entity.User;
import com.vigorride.repository.UserRepositoryWrapper;
import com.vigorride.resetPassword.data.ResetPasswordPayload;
import com.vigorride.resetPassword.exception.UserNotExistsException;
import com.vigorride.signup.Exception.ConfirmPasswordNotMatchException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResetPasswordServiceImpl implements ResetPasswordService {

    private final UserRepositoryWrapper userRepositoryWrapper;
	private final EncryptionService encryptionService;

    @Override
    public void resetPassword(ResetPasswordPayload resetPasswordPayload) {
        try {
            resetPasswordPayload.setPassword(this.encryptionService.encrypt(resetPasswordPayload.getPassword()));
            resetPasswordPayload.setConfirmPassword(this.encryptionService.encrypt(resetPasswordPayload.getConfirmPassword()));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Optional<User> user = userRepositoryWrapper.findByEmailOrUserName(resetPasswordPayload.getUserName(),
                resetPasswordPayload.getUserName());
        if (!user.isPresent()) {
            throw new UserNotExistsException(resetPasswordPayload.getUserName());
        }
        if (!resetPasswordPayload.getPassword().equals(resetPasswordPayload.getConfirmPassword())) {
			throw new ConfirmPasswordNotMatchException(resetPasswordPayload.getPassword());
		}
        user.get().setPassword(resetPasswordPayload.getPassword());
        userRepositoryWrapper.save(user.get());

    }

    private void validate() {
    }

}
