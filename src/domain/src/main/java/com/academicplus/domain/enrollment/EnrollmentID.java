package com.academicplus.domain.enrollment;

import com.academicplus.domain.Identifier;

import java.util.UUID;

public class EnrollmentID extends Identifier {

    private EnrollmentID(String value) {
        super(value);
    }

    public static EnrollmentID unique() {
        return EnrollmentID.from(UUID.randomUUID().toString());
    }

    public static EnrollmentID from(final String id) {
        return new EnrollmentID(id);
    }
}
