package com.academicplus.aplication.person;

import com.academicplus.aplication.shared.AddressDTO;
import com.academicplus.domain.person.PersonRepository;
import com.academicplus.domain.shared.Genre;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

@ExtendWith(MockitoExtension.class)
class CreatePersonUseCaseTest {
    @InjectMocks
    private CreatePersonUseCase useCase;

    @Mock
    private PersonRepository personRepository;

    @Test
    void shouldCreateAPersonAndReturnPersonOutput() {
        final var name = "Gibu";
        final var cpf = "111.111.111-85";
        final var sex = Genre.MALE;
        final var motherName = "Giboia";
        final var email = "gibu@email.com";
        final var birthDate = LocalDate.parse("1999-09-29");
        final var address = new AddressDTO("Street 1", "12A", "62800-000");
        final var input = new InputCreatePersonDTO(name, cpf, sex, motherName, email, birthDate, address);

        doAnswer(returnsFirstArg()).when(personRepository).create(any());

        final OutputCreatePersonDTO output = useCase.execute(input);

        assertNotNull(output.id());
        assertEquals(name, output.name());
        assertEquals(cpf, output.cpf());
        assertEquals(sex, output.sex());
        assertEquals(motherName, output.motherName());
        assertEquals(email, output.email());
        assertEquals(birthDate, output.birthDate());
        assertEquals(address, output.address());
    }

}