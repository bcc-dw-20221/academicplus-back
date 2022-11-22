package com.academicplus.domain.admin;

import com.academicplus.domain.AggregateRoot;
import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.systemuser.Role;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Admin extends AggregateRoot<AdminID> {
    private PersonID personID;

    private Admin(
            AdminID adminID,
            PersonID personID,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt
    ) {
        super(adminID, createdAt, updatedAt, deletedAt);
        this.personID = personID;
        this.validate();
    }

    public static Admin create(
            final AdminID adminID,
            final PersonID personID
    ) {
        final var now = Instant.now();
        return new Admin(adminID, personID, now, now, null);
    }

    @Override
    protected void validate() {

    }

    public PersonID getPersonID() {
        return personID;
    }
}
