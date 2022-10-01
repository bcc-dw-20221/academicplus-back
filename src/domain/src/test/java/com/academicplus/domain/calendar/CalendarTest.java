package com.academicplus.domain.calendar;

import com.academicplus.domain.university.UniversityID;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CalendarTest {

    @Test
    void shouldCreateACalendar() {
        final var expectedId = CalendarID.from("1");
        final var expectedDescription = "CALENDÁRIO CURSOS TÉCNICOS E SUPERIORES";
        final var expectedStartDate = LocalDate.parse("2022-07-28");
        final var expectedEndDate = LocalDate.parse("2022-12-15");
        final var expectedSchoolYear = new SchoolYear(2018, 1);
        final var expectedUniversity = UniversityID.from("13");

        final var calendar = Calendar.create(
                expectedId,
                expectedDescription,
                expectedStartDate,
                expectedEndDate,
                expectedSchoolYear,
                expectedUniversity
        );

        assertEquals(expectedId, calendar.getId());
        assertEquals(expectedDescription, calendar.getDescription());
        assertEquals(expectedStartDate, calendar.getStartDate());
        assertEquals(expectedEndDate, calendar.getEndDate());
        assertEquals(expectedSchoolYear, calendar.getSchoolYear());
        assertEquals(expectedUniversity, calendar.getUniversityID());
        assertNotNull(calendar.getCreatedAt());
        assertNotNull(calendar.getUpdatedAt());
        assertNull(calendar.getDeletedAt());
    }

}