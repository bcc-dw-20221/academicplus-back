package com.academicplus.aplication.university.find;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.university.University;
import com.academicplus.domain.university.UniversityID;
import com.academicplus.domain.university.UniversityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FindUniversityByIdUseCaseTest {
    @InjectMocks
    private FindUniversityByIdUseCase useCase;
    @Mock
    private UniversityRepository universityRepository;

    @Test
    void shouldGetUniversityById() {
        final var id = UniversityID.from("13");
        final var name = "Campus Aracati";
        final var address = new Address("Rua Ana Teles", "45", "62842-000");
        final var university = University.create(id, name, address);

        final var expectedOutput = new OutputFindUniversityByIdDTO(id.getValue(), name, address);

        doReturn(university).when(universityRepository).findById(eq(id));

        final var actualOutput = useCase.execute(id.getValue());

        assertEquals(expectedOutput, actualOutput);
    }

}