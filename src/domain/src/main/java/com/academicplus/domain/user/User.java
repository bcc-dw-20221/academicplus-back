package com.academicplus.domain.user;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Genre;
import com.academicplus.domain.shared.Person;

import java.time.Instant;
import java.time.LocalDate;

public class User extends Person<UserID> {

    private User(
            final UserID userID,
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
        super(userID, name, cpf, sex, motherName, email, birthDate, address, createdAt, updatedAt, deletedAt);
    }

    public static User create(
            final UserID userId,
            final String name,
            final String cpf,
            final Genre sex,
            final String motherName,
            final String email,
            final LocalDate birthDate,
            final Address address
    ) {
        final var now = Instant.now();
        return new User(userId, name, cpf, sex, motherName, email, birthDate, address, now, now, null);
    }

    @Override
    protected void validate() {

    }
}
