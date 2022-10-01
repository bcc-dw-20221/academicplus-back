package com.academicplus.aplication.professor;

import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.professor.Professor;
import com.academicplus.domain.professor.ProfessorID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateProfessorUseCaseTest {

    @InjectMocks
    private CreateProfessorUseCase useCase;

    @Test
    void shouldRegisterAProfessor() {
        final var personId = "1";
        final var universityId = "1";
        final var qualifications = List.of("A", "B", "C");

        final var input = new InputRegisterProfessorDTO(personId, universityId, qualifications);
        useCase.execute(input);

    }

}