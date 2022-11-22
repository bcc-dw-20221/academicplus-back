package com.academicplus.domain.person;

import com.academicplus.domain.AggregateRoot;
import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Gender;

import java.time.Instant;
import java.time.LocalDate;

public class Person extends AggregateRoot<PersonID> {
    private String name;
    private String cpf;
    private Gender gender;
    private String motherName;
    private String email;
    private LocalDate birthDate;
    private Address address;

    private Person(
            final PersonID id,
            final String name,
            final String cpf,
            final Gender gender,
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
        this.gender = gender;
        this.motherName = motherName;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.validate();
    }

    public static Person create(
            final String name,
            final String cpf,
            final Gender gender,
            final String motherName,
            final String email,
            final LocalDate birthDate,
            final Address address
    ) {
        final var now = Instant.now();
        return new Person(PersonID.unique(), name, cpf, gender, motherName, email, birthDate, address, now, now, null);
    }

    public Person update(
            final String name,
            final String cpf,
            final Gender gender,
            final String motherName,
            final String email,
            final LocalDate birthDate,
            final Address address
    ) {
        this.name = name;
        this.cpf = cpf;
        this.gender = gender;
        this.motherName = motherName;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        super.updatedAt = Instant.now();
        this.validate();
        return this;
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

    public Gender getGender() {
        return gender;
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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", gender=" + gender +
                ", motherName='" + motherName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
