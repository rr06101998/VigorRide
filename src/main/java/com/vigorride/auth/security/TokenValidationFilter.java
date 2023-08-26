package com.vigorride.auth.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vigorride.auth.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenValidationFilter extends OncePerRequestFilter {

    private JwtService jwtService;

    public TokenValidationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String token = extractToken(request);
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);

        }

        // Perform token validation here (e.g., using JWT library)
        if (isValidToken(token)) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(token, null,
                    Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    private boolean isValidToken(String token) {

        return this.jwtService.isJwtTokenValid(token);
    }

}
