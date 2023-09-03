package com.vigorride.signup.data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class SignUpPayload {
	@NotNull
	private String salutation;

	@NotNull
	private String firstName;

	private String lastName;

	@NotNull
	private Long dob;

	@NotNull
	@Email
	private String email;

	@NotNull
	private String userName;

	@NotNull
	private Long mobileNo;

	@NotNull
	private String password;

	@NotNull
	private String confirmPassword;
}
