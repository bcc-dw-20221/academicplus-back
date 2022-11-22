package com.academicplus.domain.professor;

import com.academicplus.domain.AggregateRoot;
import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.university.UniversityID;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Professor extends AggregateRoot<ProfessorID> {
    private PersonID personID;
    private UniversityID universityID;
    private List<String> qualifications;

    private Professor(
            ProfessorID professorID,
            PersonID personID,
            UniversityID universityID,
            Instant createdAt,
            Instant updatedAt,
            Instant deletedAt
    ) {
        super(professorID, createdAt, updatedAt, deletedAt);
        this.personID = personID;
        this.universityID = universityID;
        this.qualifications = new ArrayList<>();
        this.validate();
    }

    public static Professor create(
            final ProfessorID professorID,
            final PersonID personID,
            final UniversityID universityID
    ) {
        final var now = Instant.now();
        return new Professor(professorID, personID, universityID, now, now, null);
    }

    public Professor addQualification(List<String> qualifications) {
        this.qualifications.addAll(qualifications);
        this.validate();
        return this;
    }

    @Override
    protected void validate() {

    }

    public PersonID getPersonID() {
        return personID;
    }

    public UniversityID getUniversityID() {
        return universityID;
    }

    public List<String> getQualifications() {
        return Collections.unmodifiableList(qualifications);
    }
}
