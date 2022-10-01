package com.academicplus.infrastructure.configuration.usecase;

import com.academicplus.aplication.university.create.CreateUniversityUseCase;
import com.academicplus.aplication.university.find.FindUniversityByIdUseCase;
import com.academicplus.domain.university.UniversityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class UniversityUseCasesConfig {
    private final UniversityRepository universityRepository;

    public UniversityUseCasesConfig(final UniversityRepository universityRepository) {
        this.universityRepository = Objects.requireNonNull(universityRepository);
    }

    @Bean
    public CreateUniversityUseCase createUniversityUseCase() {
        return new CreateUniversityUseCase(universityRepository);
    }

    @Bean
    public FindUniversityByIdUseCase findUniversityByIdUseCase() {
        return new FindUniversityByIdUseCase(universityRepository);
    }
}
