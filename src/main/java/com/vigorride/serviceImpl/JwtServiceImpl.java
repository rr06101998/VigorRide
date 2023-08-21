package com.vigorride.serviceImpl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vigorride.service.JwtService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.JWTVerifier;

@Service
public class JwtServiceImpl implements JwtService{
	
    private String secret;
	private Algorithm algorithm;
	private JWTVerifier verifier;
	private Long tokenExpiryInMinutes;
	private final String issuer="vigor-jwt-issuer";
	private final String subject="vigor-jwt-subject";
	private final String userNameClaimKey="user-name";
	
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
	
	
}
