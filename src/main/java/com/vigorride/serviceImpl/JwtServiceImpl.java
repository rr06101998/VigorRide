package com.vigorride.serviceImpl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.vigorride.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;



@Service
public class JwtServiceImpl implements JwtService{
	
    private String secret;
	private Algorithm algorithm;
	private JWTVerifier verifier;
	private Long tokenExpiryInMinutes;
	private final String issuer="vigor-jwt-issuer";
	private final String subject="vigor-jwt-subject";
	private final String userNameClaimKey="user-name";
	
	@Autowired
	HttpServletRequest request;
	
	
	public JwtServiceImpl(@Value("${jwt-secret}") String secret,
            @Value("${jwt-token-expiry}")  Long tokenExpiryInMinutes) {
			this.secret = secret;
			this.tokenExpiryInMinutes = tokenExpiryInMinutes;
			algorithm=Algorithm.HMAC256(secret);
			this.verifier=JWT.require(algorithm)
					      .withIssuer(issuer)
					      .withClaimPresence(userNameClaimKey)
					      .withSubject(subject)
					      .build();
	}
	

	@Override
	public String createJwtToken(String username) {
		
		return JWT.create()
				.withIssuer(issuer)
				.withSubject(subject)
				.withClaim(userNameClaimKey, username)
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis()+tokenExpiryInMinutes*60*1000))
				.withJWTId(UUID.randomUUID().toString())
				.sign(algorithm);
	}
	
	@Override
	public Boolean isJwtTokenValid(String jwtToken) {
	    try {
	        DecodedJWT decodedJWT = verifier.verify(jwtToken);
	        return true;
	    } catch (JWTVerificationException e) {
	        // Nothing to do, invalid token
	    }
	    return false;
	}

	@Override
	public String getUserName(String jwtToken) {
	    try {
	        DecodedJWT decodedJWT = verifier.verify(jwtToken);
	        return decodedJWT.getClaim(userNameClaimKey).asString();
	    } catch (JWTVerificationException e) {
	        // Nothing to do, invalid token
	    	
	    }
	    return null;
	}

	@Override
	public String getUserNameInBearer(String rawToken) {
	    return getUserName(rawToken.substring(7));
	}
	
	@Override
	public String getCurrentUser() {
		String authHeader=request.getHeader("Authorization");
		if(authHeader!=null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
			String jwt=authHeader.substring(7);
			return getUserName(jwt);
		}
		return null;
	}

	
	
}
