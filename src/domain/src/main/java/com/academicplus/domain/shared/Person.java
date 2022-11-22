package com.academicplus.domain.shared;

import com.academicplus.domain.AggregateRoot;
import com.academicplus.domain.Identifier;

import java.time.Instant;
import java.time.LocalDate;

public abstract class Person<ID extends Identifier> extends AggregateRoot<ID> {
    protected String name;
    protected String cpf;
    protected Gender sex;
    protected String motherName;
    protected String email;
    protected LocalDate birthDate;
    protected Address address;

    protected Person(
            final ID id,
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
        super(id, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.cpf = cpf;
        this.sex = sex;
        this.motherName = motherName;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Gender getSex() {
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
