package com.academicplus.domain.student;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Genre;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void shouldCreateAStudent() {
        final var expectedRegister = StudentID.from("20182" + "13" + "500" + "0327");
        final var expectedName = "Ernesto Moraes";
        final var expectedCpf = "111.111.111-11";
        final var expectedSex = Genre.MALE;
        final var expectedMom = "Mãe do Ernesto";
        final var expectedEmail = "ernesto@email.com";
        final var expectedBirthDate = LocalDate.parse("1999-04-10");
        final var expectedAddress = new Address("Rua Beberibe", "00", "62840-000");

        final var student = Student.create(
                expectedRegister,
                expectedName,
                expectedCpf,
                expectedSex,
                expectedMom,
                expectedEmail,
                expectedBirthDate,
                expectedAddress
        );

        assertEquals(expectedRegister, student.getId());
        assertEquals(expectedName, student.getName());
        assertEquals(expectedCpf, student.getCpf());
        assertEquals(expectedSex, student.getSex());
        assertEquals(expectedMom, student.getMotherName());
        assertEquals(expectedEmail, student.getEmail());
        assertEquals(expectedBirthDate, student.getBirthDate());
        assertEquals(expectedAddress, student.getAddress());
        assertNotNull(student.getCreatedAt());
        assertNotNull(student.getUpdatedAt());
        assertNull(student.getDeletedAt());
    }
}