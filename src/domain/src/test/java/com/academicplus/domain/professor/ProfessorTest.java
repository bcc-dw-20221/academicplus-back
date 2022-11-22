package com.academicplus.domain.professor;

import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.university.UniversityID;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Test
    void shouldCreateAProfessor() {
        final var professorId = ProfessorID.from("1");
        final var username = "prof@email.com";
        final var password = "profPass";
        final var personId = PersonID.from("1");
        final var universityId = UniversityID.from("1");
        final var qualifications = List.of("A", "B", "C");

        final var professor = Professor.create(professorId, personId, universityId, username, password);

        professor.addQualification(qualifications);

        assertEquals(professorId, professor.getId());
        assertEquals(personId, professor.getPersonID());
    }

}