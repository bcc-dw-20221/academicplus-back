package com.academicplus.infrastructure.configuration.usecase;

import com.academicplus.aplication.gateway.PasswordEncoder;
import com.academicplus.aplication.systemuser.CreateSystemUserUseCase;
import com.academicplus.domain.systemuser.SystemUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemUserUseCaseConfig {
    private final SystemUserRepository systemUserRepository;
    private final PasswordEncoder passwordEncoder;

    public SystemUserUseCaseConfig(SystemUserRepository systemUserRepository, PasswordEncoder passwordEncoder) {
        this.systemUserRepository = systemUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CreateSystemUserUseCase createSystemUserUseCase() {
        return new CreateSystemUserUseCase(systemUserRepository, passwordEncoder);
    }
}
