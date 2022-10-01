package com.academicplus.domain.calendar;

import com.academicplus.domain.AggregateRoot;
import com.academicplus.domain.university.UniversityID;

import java.time.Instant;
import java.time.LocalDate;

public class Calendar extends AggregateRoot<CalendarID> {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private SchoolYear schoolYear;
    private UniversityID universityID;

    private Calendar(
            final CalendarID calendarID,
            final String description,
            final LocalDate startDate,
            final LocalDate endDate,
            final SchoolYear schoolYear,
            final UniversityID universityID,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(calendarID, createdAt,  updatedAt, deletedAt);
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.schoolYear = schoolYear;
        this.universityID = universityID;
        this.validate();
    }

    public static Calendar create(
            final CalendarID id,
            final String description,
            final LocalDate startDate,
            final LocalDate endDate,
            final SchoolYear schoolYear,
            final UniversityID universityID
    ) {
        final var now = Instant.now();
        return new Calendar(id, description, startDate, endDate, schoolYear, universityID, now, now, null);
    }

    @Override
    protected void validate() {

    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public UniversityID getUniversityID() {
        return universityID;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", schoolYear=" + schoolYear +
                ", universityID=" + universityID +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", id=" + id +
                '}';
    }
}
