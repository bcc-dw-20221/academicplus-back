package com.academicplus.domain.person;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Gender;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void shouldCreateAPerson() {
        final var name = "Gibu";
        final var cpf = "111.111.111-85";
        final var gender = Gender.MALE;
        final var motherName = "Giboia";
        final var email = "gibu@email.com";
        final var birthDate = LocalDate.parse("1999-09-29");
        final var address = new Address("Street 1", "12A", "62800-000");

        final var person = Person.create(name, cpf, gender, motherName, email, birthDate, address);

        assertNotNull(person.getId());
        assertEquals(name, person.getName());
        assertEquals(cpf, person.getCpf());
        assertEquals(gender, person.getGender());
        assertEquals(motherName, person.getMotherName());
        assertEquals(email, person.getEmail());
        assertEquals(birthDate, person.getBirthDate());
        assertEquals(address, person.getAddress());
        assertNotNull(person.getCreatedAt());
        assertNotNull(person.getUpdatedAt());
        assertNull(person.getDeletedAt());
    }

    @Test
    void shouldUpdateAPerson() {
        final var name = "Gibu atualizado";
        final var cpf = "111.111.111-85";
        final var gender = Gender.MALE;
        final var motherName = "Giboia atualizado";
        final var email = "gibu@email.com.br";
        final var birthDate = LocalDate.parse("1999-09-29");
        final var address = new Address("Street 1 atualizado", "12A atualizado", "62842-000");

        final var person = Person.create(
                "Gibu",
                "111.111.111-85",
                Gender.FEMALE,
                "Giboia",
                "gibu@email.com",
                LocalDate.parse("1999-08-29"),
                new Address("Street 1", "12A", "62800-000")
        );

        final var lastUpdatedAt = person.getUpdatedAt();

        person.update(name, cpf, gender, motherName, email, birthDate, address);

        assertNotNull(person.getId());
        assertEquals(name, person.getName());
        assertEquals(cpf, person.getCpf());
        assertEquals(gender, person.getGender());
        assertEquals(motherName, person.getMotherName());
        assertEquals(email, person.getEmail());
        assertEquals(birthDate, person.getBirthDate());
        assertEquals(address, person.getAddress());
        assertNotNull(person.getCreatedAt());
        assertTrue(person.getUpdatedAt().isAfter(lastUpdatedAt));
        assertNull(person.getDeletedAt());
    }

}