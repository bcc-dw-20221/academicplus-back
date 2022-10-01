package com.academicplus.domain.course;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @Test
    void giveAValidParams_whenCallsCreate_thenShouldCreateACourse() {
        final var expectedId = CourseID.from("500");
        final var expectedName = "Bacharelado em Ciência da Computação";
        final var expectedHours = 3000;
        final var expectedLevel = CourseLevel.BACHAREL;
        final var expectedGrau = Grau.SUPERIOR;

        final var course = Course.create(expectedId, expectedName, expectedHours, expectedLevel, expectedGrau);

        assertEquals(expectedId, course.getId());
        assertEquals(expectedName, course.getName());
        assertEquals(expectedHours, course.getHours());
        assertEquals(expectedLevel, course.getLevel());
        assertEquals(expectedGrau, course.getGrau());
        assertNotNull(course.getCreatedAt());
        assertNotNull(course.getUpdatedAt());
        assertNull(course.getDeletedAt());
    }

}