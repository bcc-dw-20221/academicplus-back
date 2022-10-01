package com.academicplus.domain.enrollment;

import com.academicplus.domain.course.CourseID;
import com.academicplus.domain.person.PersonID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentTest {

    @Test
    void shouldEnrollPersonInACourse() {
        final var expectedId = EnrollmentID.from("1");
        final var expectedPersonId = PersonID.from("1");
        final var expectedCourseId = CourseID.from("1");

        final var enrollment = Enrollment.create(expectedId, expectedPersonId, expectedCourseId);

        assertEquals(expectedId, enrollment.getId());
        assertEquals(expectedPersonId, enrollment.getPersonID());
        assertEquals(expectedCourseId, enrollment.getCourseID());
    }

}