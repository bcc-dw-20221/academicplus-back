package com.academicplus.aplication.student;

import com.academicplus.domain.course.CourseID;
import com.academicplus.domain.course.CourseRepository;
import com.academicplus.domain.enrollment.Enrollment;
import com.academicplus.domain.enrollment.EnrollmentID;
import com.academicplus.domain.enrollment.EnrollmentRepository;
import com.academicplus.domain.exception.DomainException;
import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.person.PersonRepository;

import java.util.Objects;

public class EnrollStudentUseCase {
    private final PersonRepository personRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollStudentUseCase(
            final PersonRepository personRepository,
            final CourseRepository courseRepository,
            final EnrollmentRepository enrollmentRepository
    ) {
        this.personRepository = Objects.requireNonNull(personRepository);
        this.courseRepository = Objects.requireNonNull(courseRepository);
        this.enrollmentRepository = Objects.requireNonNull(enrollmentRepository);
    }

    public OutputEnrollStudentDTO execute(final InputEnrollStudentDTO input) {
        final var personId = PersonID.from(input.personId());
        final var courseId = CourseID.from(input.courseId());

        final var existsPerson = this.personRepository.existsById(personId);
        final var existsCourse = this.courseRepository.existsById(courseId);

        if (!existsPerson || !existsCourse)
            throw new DomainException("Unable to enroll student");

        final var enrollment = Enrollment.create(EnrollmentID.unique(), personId, courseId);
        this.enrollmentRepository.create(enrollment);
        return new OutputEnrollStudentDTO(enrollment.getId().getValue());
    }
}
