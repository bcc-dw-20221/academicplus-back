package com.academicplus.aplication.professor;

import com.academicplus.aplication.gateway.PasswordEncoder;
import com.academicplus.domain.person.PersonRepository;
import com.academicplus.domain.professor.ProfessorRepository;
import com.academicplus.domain.university.UniversityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CreateProfessorUseCaseTest {

    @InjectMocks
    private CreateProfessorUseCase useCase;
    @Mock
    private ProfessorRepository professorRepository;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private UniversityRepository universityRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void shouldRegisterAProfessor() {
        final var personId = "1";
        final var universityId = "1";
        final var username = "prof@email.com";
        final var password = "profPass";
        final var qualifications = List.of("A", "B", "C");

        doReturn(true).when(personRepository).existsById(any());
        doReturn(true).when(universityRepository).existsById(any());
        doReturn(false).when(professorRepository).existsByUsername(any());
        doReturn("encodedPass").when(passwordEncoder).encode(any());

        final var input = new InputRegisterProfessorDTO(personId, universityId, username, password, qualifications);
        useCase.execute(input);
    }

}