package com.academicplus.domain.user;

import com.academicplus.domain.Identifier;

import java.util.UUID;

public class UserID extends Identifier {

    private UserID(String value) {
        super(value);
    }

    public static UserID unique() {
        return UserID.from(UUID.randomUUID().toString());
    }

    public static UserID from(final String id) {
        return new UserID(id);
    }
}
