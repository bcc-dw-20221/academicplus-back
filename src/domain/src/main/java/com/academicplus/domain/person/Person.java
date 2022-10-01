package com.academicplus.domain.person;

import com.academicplus.domain.AggregateRoot;
import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Genre;

import java.time.Instant;
import java.time.LocalDate;

public class Person extends AggregateRoot<PersonID> {
    private String name;
    private String cpf;
    private Genre sex;
    private String motherName;
    private String email;
    private LocalDate birthDate;
    private Address address;

    private Person(
            final PersonID id,
            final String name,
            final String cpf,
            final Genre sex,
            final String motherName,
            final String email,
            final LocalDate birthDate,
            final Address address,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(id, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.motherName = motherName;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
    }

    public static Person create(
            final String name,
            final String cpf,
            final Genre sex,
            final String motherName,
            final String email,
            final LocalDate birthDate,
            final Address address
    ) {
        final var now = Instant.now();
        return new Person(PersonID.unique(), name, cpf, sex, motherName, email, birthDate, address, now, now, null);
    }

    @Override
    protected void validate() {

    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Genre getSex() {
        return sex;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Address getAddress() {
        return address;
    }
}
