package com.academicplus.domain.admin;

import com.academicplus.domain.Identifier;

import java.util.UUID;

public class AdminID extends Identifier {
    private AdminID(String value) {
        super(value);
    }

    public static AdminID unique() {
        return AdminID.from(UUID.randomUUID().toString());
    }

    public static AdminID from(final String id) {
        return new AdminID(id);
    }
}
