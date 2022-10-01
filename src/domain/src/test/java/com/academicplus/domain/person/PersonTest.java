package com.academicplus.domain.person;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Genre;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void shouldCreateAPerson() {
        final var name = "Gibu";
        final var cpf = "111.111.111-85";
        final var sex = Genre.MALE;
        final var motherName = "Giboia";
        final var email = "gibu@email.com";
        final var birthDate = LocalDate.parse("1999-09-29");
        final var address = new Address("Street 1", "12A", "62800-000");

        final var person = Person.create(name, cpf, sex, motherName, email, birthDate, address);

        assertNotNull(person.getId());
        assertEquals(name, person.getName());
        assertEquals(cpf, person.getCpf());
        assertEquals(sex, person.getSex());
        assertEquals(motherName, person.getMotherName());
        assertEquals(email, person.getEmail());
        assertEquals(birthDate, person.getBirthDate());
        assertEquals(address, person.getAddress());
        assertNotNull(person.getCreatedAt());
        assertNotNull(person.getUpdatedAt());
        assertNull(person.getDeletedAt());
    }

}