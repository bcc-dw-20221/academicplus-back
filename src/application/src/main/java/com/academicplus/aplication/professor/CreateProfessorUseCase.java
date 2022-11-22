package com.academicplus.aplication.professor;

import com.academicplus.aplication.gateway.PasswordEncoder;
import com.academicplus.domain.exception.DomainException;
import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.person.PersonRepository;
import com.academicplus.domain.professor.Professor;
import com.academicplus.domain.professor.ProfessorID;
import com.academicplus.domain.professor.ProfessorRepository;
import com.academicplus.domain.university.UniversityID;
import com.academicplus.domain.university.UniversityRepository;

public class CreateProfessorUseCase {
    private final ProfessorRepository professorRepository;
    private final PersonRepository personRepository;
    private final UniversityRepository universityRepository;

    public CreateProfessorUseCase(
            ProfessorRepository professorRepository,
            PersonRepository personRepository,
            UniversityRepository universityRepository
    ) {
        this.professorRepository = professorRepository;
        this.personRepository = personRepository;
        this.universityRepository = universityRepository;
    }

    public OutputRegisterProfessorDTO execute(final InputRegisterProfessorDTO input) {
        final var personId = PersonID.from(input.personId());
        final var universityId = UniversityID.from(input.universityId());
        validation(personId, universityId);
        final var professor = Professor.create(ProfessorID.unique(), personId, universityId);
        professor.addQualification(input.qualifications());
        this.professorRepository.create(professor);
        return new OutputRegisterProfessorDTO(professor.getId().getValue(), professor.getPersonID().getValue(), professor.getUniversityID().getValue());
    }

    private void validation(PersonID personId, UniversityID universityId) {
        final var existsPerson = this.personRepository.existsById(personId);
        if (!existsPerson)
            throw new DomainException("Person not found");

        final var existsUniversity = this.universityRepository.existsById(universityId);
        if (!existsUniversity)
            throw new DomainException("University not found");
    }
}
