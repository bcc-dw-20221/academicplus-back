package com.academicplus.infrastructure.repository;

import com.academicplus.domain.professor.Professor;
import com.academicplus.domain.professor.ProfessorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfessorRepositoryMemory implements ProfessorRepository {
    private static final List<Professor> professors = new ArrayList<>();

    @Override
    public Professor create(Professor professor) {
        professors.add(professor);
        return professor;
    }

    @Override
    public List<Professor> findAll() {
        return professors;
    }
}
