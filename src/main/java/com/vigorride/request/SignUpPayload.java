package com.vigorride.request;

import java.time.LocalDate;

import com.vigorride.entity.Address;

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
	private String employeeId;
	
	@NotNull
	private String salutation;	
	
	@NotNull
	private String firstName;
	
	private String lastName;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	private String confirmPassword;
	
	@NotNull
	private String dealer;
	
	@NotNull
	private Long dob;
	
	private String socialSecurity;
	
	@NotNull
	private String spiffPaid;
	
	private Address homeAddress;
	
	private Address businessAddress;
	
	@NotNull
	private Boolean  agreeToUniversalTermsOfService;
	
	@NotNull
	private Boolean  agreeToProgramTermsAndConditions ;	
}
