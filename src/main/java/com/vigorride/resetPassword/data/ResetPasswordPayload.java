package com.vigorride.resetPassword.data;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ResetPasswordPayload {
	@NotNull
	private String userName;

	private String password;

	private String confirmPassword;
}
