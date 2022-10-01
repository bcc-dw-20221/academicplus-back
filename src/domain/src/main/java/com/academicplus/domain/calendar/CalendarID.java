package com.academicplus.domain.calendar;

import com.academicplus.domain.Identifier;

import java.util.UUID;

public class CalendarID extends Identifier {
    private CalendarID(final String value) {
        super(value);
    }

    public static CalendarID unique() {
        return CalendarID.from(UUID.randomUUID().toString());
    }

    public static CalendarID from(final String id) {
        return new CalendarID(id);
    }
}
