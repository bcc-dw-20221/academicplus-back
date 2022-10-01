package com.academicplus.domain.university;

import com.academicplus.domain.Identifier;
import java.util.UUID;

public class UniversityID extends Identifier {

    private UniversityID(String value) {
        super(value);
    }

    public static UniversityID unique() {
        return UniversityID.from(UUID.randomUUID().toString());
    }

    public static UniversityID from(final String id) {
        return new UniversityID(id);
    }
}
