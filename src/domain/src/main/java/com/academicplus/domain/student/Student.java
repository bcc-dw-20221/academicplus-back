package com.academicplus.domain.student;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Person;
import com.academicplus.domain.shared.Gender;

import java.time.Instant;
import java.time.LocalDate;

public class Student extends Person<StudentID> {
    private Student(
            final StudentID studentID,
            final String name,
            final String cpf,
            final Gender sex,
            final String motherName,
            final String email,
            final LocalDate birthDate,
            final Address address,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(studentID, name, cpf, sex, motherName, email, birthDate, address, createdAt, updatedAt, deletedAt);
        this.validate();
    }

    public static Student create(
            final StudentID register,
            final String name,
            final String cpf,
            final Gender sex,
            final String motherName,
            final String email,
            final LocalDate birthDate,
            final Address address
    ) {
        final var now = Instant.now();
        return new Student(register, name, cpf, sex, motherName, email, birthDate, address, now, now, null);
    }

    @Override
    protected void validate() {

    }
}
