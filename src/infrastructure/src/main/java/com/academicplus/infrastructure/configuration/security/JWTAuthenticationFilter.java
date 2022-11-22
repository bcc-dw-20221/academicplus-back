package com.academicplus.infrastructure.configuration.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    public static final int TOKEN_EXPIRATION = 600_000;
    public static final String TOKEN_PASS = "STRONG_TOKEN_PASS";
    public static final String TOKEN_CLAIM = "roles";

    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        final var user = (User) authResult.getPrincipal();
        final var token = createJWT(user);
        record AuthResponse(String accessToken) {}
        final var responseBody = new AuthResponse(token);
        response.getWriter().write(new ObjectMapper().writeValueAsString(responseBody));
//        response.getWriter().flush();
    }

    private String createJWT(User user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim(TOKEN_CLAIM, user.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList())
                .withExpiresAt(Instant.now().plusMillis(TOKEN_EXPIRATION))
                .sign(Algorithm.HMAC512(TOKEN_PASS));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            record UserLogin(String username, String password) { }
            final var user = new ObjectMapper().readValue(request.getInputStream(), UserLogin.class);
            final var authentication = new UsernamePasswordAuthenticationToken(user.username(), user.password());
            return authenticationManager.authenticate(authentication);
        } catch (IOException e) {
            throw new RuntimeException("Fail to authenticate user", e);
        }
    }
}