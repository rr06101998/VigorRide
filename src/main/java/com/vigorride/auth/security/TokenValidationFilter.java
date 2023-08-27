package com.vigorride.auth.security;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.vigorride.auth.service.JwtService;
import com.vigorride.entity.Role;
import com.vigorride.entity.User;
import com.vigorride.repository.RoleRepositoryWrapper;
import com.vigorride.repository.UserRepositoryWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenValidationFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    @Autowired
    private RoleRepositoryWrapper roleRepositoryWrapper;
    @Autowired
    private UserRepositoryWrapper userRepositoryWrapper;

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
            String userName=jwtService.getUserName(token);
            Optional<User> user=userRepositoryWrapper.findUserByName(userName);
            Set<Role> role=roleRepositoryWrapper.getByUserId(user.get().getId());
            
            Collection<GrantedAuthority> authorities=mapRolesToAuthorities(role);
            
            Authentication authentication = new UsernamePasswordAuthenticationToken(token, null,
            authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
        return roles.stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
            .collect(Collectors.toList());
    }

    private String extractToken(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }

    private boolean isValidToken(String token) {

        return this.jwtService.isJwtTokenValid(token);
    }

}
