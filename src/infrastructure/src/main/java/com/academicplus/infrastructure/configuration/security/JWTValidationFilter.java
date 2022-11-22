package com.academicplus.infrastructure.configuration.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.academicplus.infrastructure.configuration.security.JWTAuthenticationFilter.TOKEN_CLAIM;
import static com.academicplus.infrastructure.configuration.security.JWTAuthenticationFilter.TOKEN_PASS;

public class JWTValidationFilter extends BasicAuthenticationFilter {
    public static final String HEADER_FIELD = "Authorization";
    public static final String PREFIX = "Bearer ";

    public JWTValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException {
        try {
            final var field = request.getHeader(HEADER_FIELD);
            if (Objects.isNull(field) || !field.startsWith(PREFIX)) {
                chain.doFilter(request, response);
                return;
            }
            final var token = field.replace(PREFIX, "");
            final var  authenticationToken = getAuthenticationToken(token);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request, response);
        } catch (Exception e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            record ErrorMessage(String errorMessage) {}
            response.getWriter().write(new ObjectMapper().writeValueAsString(new ErrorMessage(e.getMessage())));
        }
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        final var jwt = JWT.require(Algorithm.HMAC512(TOKEN_PASS)).build().verify(token);
        final var username = jwt.getSubject();
        final var authorities = jwt.getClaim(TOKEN_CLAIM).asList(String.class).stream().map(SimpleGrantedAuthority::new).toList();
        return Objects.nonNull(username) ? new UsernamePasswordAuthenticationToken(username, null, authorities) : null;
    }
}
