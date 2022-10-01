package com.academicplus.domain.enrollment;

import java.util.List;

public interface EnrollmentRepository {
    Enrollment create(Enrollment enrollment);


    List<Enrollment> findAll(); //TODO: Remove this
}
