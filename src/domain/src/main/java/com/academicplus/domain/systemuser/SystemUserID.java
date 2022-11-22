package com.academicplus.domain.systemuser;

import com.academicplus.domain.Identifier;

import java.util.UUID;

public class SystemUserID extends Identifier {
    private SystemUserID(String value) {
        super(value);
    }

    public static SystemUserID unique() {
        return SystemUserID.from(UUID.randomUUID().toString());
    }

    public static SystemUserID from(final String id) {
        return new SystemUserID(id);
    }
}
