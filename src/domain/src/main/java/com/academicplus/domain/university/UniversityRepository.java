package com.academicplus.domain.university;

import java.util.List;

public interface UniversityRepository {
    University create(University university);
    University findById(UniversityID id);
    List<University> findAll();

    boolean existsById(UniversityID universityId);
}
