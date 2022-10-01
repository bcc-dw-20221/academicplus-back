package com.academicplus.domain.professor;

import java.util.List;

public interface ProfessorRepository {
    Professor create(Professor professor);

    List<Professor> findAll(); //TODO: Remove this;
}
