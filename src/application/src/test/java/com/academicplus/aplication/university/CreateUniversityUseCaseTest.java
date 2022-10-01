package com.academicplus.aplication.university;

import com.academicplus.aplication.university.create.CreateUniversityUseCase;
import com.academicplus.aplication.university.create.InputCreateUniversityDTO;
import com.academicplus.domain.university.UniversityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

@ExtendWith(MockitoExtension.class)
class CreateUniversityUseCaseTest {
    @InjectMocks
    private CreateUniversityUseCase useCase;
    @Mock
    private UniversityRepository universityRepository;

    @Test
    void shouldCreateUniversity() {
        final var input = new InputCreateUniversityDTO("Campus Aracati", "Rua Ana Teles", "45", "62842-000");

        doAnswer(returnsFirstArg()).when(universityRepository).create(any());

        final var output = useCase.execute(input);

        assertNotNull(output.id());
    }

}