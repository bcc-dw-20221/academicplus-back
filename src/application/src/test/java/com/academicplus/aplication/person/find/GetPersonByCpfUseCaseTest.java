package com.academicplus.aplication.person.find;

import com.academicplus.aplication.shared.AddressDTO;
import com.academicplus.domain.person.Person;
import com.academicplus.domain.person.PersonRepository;
import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Gender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class GetPersonByCpfUseCaseTest {
    @InjectMocks
    private GetPersonByCpfUseCase useCase;
    @Mock
    private PersonRepository personRepository;

    @Test
    void shouldGetPersonByCpf() {
        final var name = "Gibu";
        final var cpf = "111.111.111-85";
        final var gender = Gender.MALE;
        final var motherName = "Giboia";
        final var email = "gibu@email.com";
        final var birthDate = LocalDate.parse("1999-09-29");
        final var address = new Address("Street 1", "12A", "62800-000");
        final var person = Person.create(name, cpf, gender, motherName, email, birthDate, address);

        doReturn(person).when(personRepository).findByCpf(any());

        final var input = "111.111.111-85";
        final var output = useCase.execute(input);

        assertNotNull(person.getId());
        assertEquals(name, output.name());
        assertEquals(cpf, output.cpf());
        assertEquals(gender, output.gender());
        assertEquals(motherName, output.motherName());
        assertEquals(email, output.email());
        assertEquals(birthDate, output.birthDate());
        assertEquals(AddressDTO.from(address), output.address());
    }

}