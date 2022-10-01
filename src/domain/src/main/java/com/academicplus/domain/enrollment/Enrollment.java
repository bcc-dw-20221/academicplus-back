package com.academicplus.domain.enrollment;

import com.academicplus.domain.AggregateRoot;
import com.academicplus.domain.course.CourseID;
import com.academicplus.domain.person.PersonID;

import java.time.Instant;

public class Enrollment extends AggregateRoot<EnrollmentID> {
    private PersonID personID;
    private CourseID courseID;

    public Enrollment(
            final EnrollmentID enrollmentID,
            final PersonID personID,
            final CourseID courseID,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(enrollmentID, createdAt, updatedAt, deletedAt);
        this.personID = personID;
        this.courseID = courseID;
    }

    public static Enrollment create(final EnrollmentID id, final PersonID personId, final CourseID courseId) {
        final var now = Instant.now();
        return new Enrollment(id, personId, courseId, now, now, null);
    }

    @Override
    protected void validate() {

    }

    public PersonID getPersonID() {
        return personID;
    }

    public CourseID getCourseID() {
        return courseID;
    }
}
