package com.academicplus.domain.professor;

import com.academicplus.domain.Identifier;

import java.util.UUID;

public class ProfessorID extends Identifier {
    private ProfessorID(String value) {
        super(value);
    }

    public static ProfessorID unique() {
        return ProfessorID.from(UUID.randomUUID().toString());
    }

    public static ProfessorID from(final String id) {
        return new ProfessorID(id);
    }
}
