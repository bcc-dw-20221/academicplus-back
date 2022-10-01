package com.academicplus.infrastructure.configuration.usecase;

import com.academicplus.aplication.person.CreatePersonUseCase;
import com.academicplus.domain.person.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class PersonUseCaseConfig {
    private final PersonRepository personRepository;

    public PersonUseCaseConfig(final PersonRepository personRepository) {
        this.personRepository = Objects.requireNonNull(personRepository);
    }

    @Bean
    public CreatePersonUseCase createPersonUseCase() {
        return new CreatePersonUseCase(personRepository);
    }
}
