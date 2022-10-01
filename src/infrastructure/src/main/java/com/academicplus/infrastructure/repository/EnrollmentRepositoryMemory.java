package com.academicplus.infrastructure.repository;

import com.academicplus.domain.enrollment.Enrollment;
import com.academicplus.domain.enrollment.EnrollmentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepositoryMemory implements EnrollmentRepository {
    private static final List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public Enrollment create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollments;
    }
}
