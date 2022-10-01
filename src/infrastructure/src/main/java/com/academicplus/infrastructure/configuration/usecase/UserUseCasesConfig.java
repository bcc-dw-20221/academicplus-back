package com.academicplus.infrastructure.configuration.usecase;

import com.academicplus.aplication.user.create.CreateUserUseCase;
import com.academicplus.aplication.user.find.FindUserByIdUseCase;
import com.academicplus.domain.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class UserUseCasesConfig {
    private final UserRepository userRepository;

    public UserUseCasesConfig(final UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository);
    }

    @Bean
    public CreateUserUseCase createUserUseCase() {
        return new CreateUserUseCase(userRepository);
    }

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase() {
        return new FindUserByIdUseCase(userRepository);
    }
}
