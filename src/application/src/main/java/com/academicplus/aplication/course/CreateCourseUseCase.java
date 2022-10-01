package com.academicplus.aplication.course;

import com.academicplus.domain.course.Course;
import com.academicplus.domain.course.CourseID;
import com.academicplus.domain.course.CourseRepository;

import java.util.Objects;

public class CreateCourseUseCase {
    private final CourseRepository courseRepository;

    public CreateCourseUseCase(final CourseRepository courseRepository) {
        this.courseRepository = Objects.requireNonNull(courseRepository);
    }

    public OutputCreateCourseDTO execute(final InputCreateCourseDTO input) {
        final var course = Course.create(CourseID.unique(), input.name(), input.hours(), input.level(), input.grau());
        this.courseRepository.create(course);
        return new OutputCreateCourseDTO(course.getId().getValue(), course.getName(), course.getHours(), course.getLevel(), course.getGrau());
    }
}
