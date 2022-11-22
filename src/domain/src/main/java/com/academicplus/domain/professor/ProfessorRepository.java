package com.academicplus.domain.professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository {
    Professor create(Professor professor);

    List<Professor> findAll(); //TODO: Remove this;

//    Optional<Professor> findByUsername(String username);
//
//    boolean existsByUsername(String username);
}
