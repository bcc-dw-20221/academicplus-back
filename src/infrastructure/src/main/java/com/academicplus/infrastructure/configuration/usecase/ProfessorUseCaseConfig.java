package com.academicplus.infrastructure.configuration.usecase;

import com.academicplus.aplication.gateway.PasswordEncoder;
import com.academicplus.aplication.professor.CreateProfessorUseCase;
import com.academicplus.domain.person.PersonRepository;
import com.academicplus.domain.professor.ProfessorRepository;
import com.academicplus.domain.university.UniversityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfessorUseCaseConfig {
    private final ProfessorRepository professorRepository;
    private final PersonRepository personRepository;
    private final UniversityRepository universityRepository;

    public ProfessorUseCaseConfig(ProfessorRepository professorRepository, PersonRepository personRepository, UniversityRepository universityRepository) {
        this.professorRepository = professorRepository;
        this.personRepository = personRepository;
        this.universityRepository = universityRepository;
    }

    @Bean
    public CreateProfessorUseCase createProfessorUseCase() {
        return new CreateProfessorUseCase(professorRepository, personRepository, universityRepository);
    }
}
