package com.academicplus.domain.person;

import com.academicplus.domain.Identifier;

import java.util.UUID;

public class PersonID extends Identifier {

    private PersonID(final String value) {
        super(value);
    }

    public static PersonID unique() {
        return PersonID.from(UUID.randomUUID().toString());
    }

    public static PersonID from(final String id) {
        return new PersonID(id);
    }
}
