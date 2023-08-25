package com.vigorride.service;

public interface JwtService {
	
    String createJwtToken(String username);

	Boolean isJwtTokenValid(String jwtToken);

	String getUserName(String jwtToken);

	String getUserNameInBearer(String rawToken);

	String getCurrentUser();
	
}
