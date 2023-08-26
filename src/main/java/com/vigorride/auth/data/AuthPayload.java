package com.vigorride.auth.data;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AuthPayload {
    
	@NotNull
	private String username;
	
	@NotNull
	private String password;
}
