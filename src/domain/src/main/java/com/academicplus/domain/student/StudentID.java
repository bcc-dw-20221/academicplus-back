package com.academicplus.domain.student;

import com.academicplus.domain.Identifier;

import java.util.UUID;

public class StudentID extends Identifier {
    private StudentID(String value) {
        super(value);
    }

    public static StudentID unique() {
        return StudentID.from(UUID.randomUUID().toString());
    }

    public static StudentID from(final String id) {
        return new StudentID(id);
    }
}
