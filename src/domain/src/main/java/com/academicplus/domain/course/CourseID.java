package com.academicplus.domain.course;

import com.academicplus.domain.Identifier;

import java.util.UUID;

public class CourseID extends Identifier {

    private CourseID(final String value) {
        super(value);
    }

    public static CourseID unique() {
        return CourseID.from(UUID.randomUUID().toString());
    }

    public static CourseID from(final String id) {
        return new CourseID(id);
    }
}
