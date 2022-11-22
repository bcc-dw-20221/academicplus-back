package com.academicplus.infrastructure.gateway;

import com.academicplus.aplication.gateway.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderImpl implements PasswordEncoder {
    private final org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    public PasswordEncoderImpl(org.springframework.security.crypto.password.PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
