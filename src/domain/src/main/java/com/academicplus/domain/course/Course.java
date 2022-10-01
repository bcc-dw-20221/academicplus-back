package com.academicplus.domain.course;

import com.academicplus.domain.AggregateRoot;

import java.time.Instant;

public class Course extends AggregateRoot<CourseID> {
    private String name;
    private Long hours;
    private CourseLevel level;
    private Grau grau;

    private Course(
            final CourseID courseID,
            final String name,
            final Long hours,
            final CourseLevel level,
            final Grau grau,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(courseID, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.hours = hours;
        this.level = level;
        this.grau = grau;
    }

    public static Course create(
            final CourseID id,
            final String name,
            final long hours,
            final CourseLevel level,
            final Grau grau
    ) {
        final var now = Instant.now();
        return new Course(id, name, hours, level, grau, now, now, null);
    }

    @Override
    protected void validate() {

    }

    public String getName() {
        return name;
    }

    public Long getHours() {
        return hours;
    }

    public CourseLevel getLevel() {
        return level;
    }

    public Grau getGrau() {
        return grau;
    }
}
