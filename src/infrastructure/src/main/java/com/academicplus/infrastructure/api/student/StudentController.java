package com.academicplus.infrastructure.api.student;

import com.academicplus.aplication.student.EnrollStudentUseCase;
import com.academicplus.aplication.student.InputEnrollStudentDTO;
import com.academicplus.aplication.student.OutputEnrollStudentDTO;
import com.academicplus.domain.enrollment.Enrollment;
import com.academicplus.domain.enrollment.EnrollmentRepository;
import com.academicplus.domain.student.Student;
import com.academicplus.domain.student.StudentRepository;
import com.academicplus.domain.university.University;
import com.academicplus.domain.university.UniversityRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/students")
@Tag(name = "Student")
public class StudentController {
    private final EnrollStudentUseCase enrollStudentUseCase;

    public StudentController(final EnrollStudentUseCase enrollStudentUseCase) {
        this.enrollStudentUseCase = Objects.requireNonNull(enrollStudentUseCase);
    }

    @PreAuthorize("hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN')")
    @PostMapping("/enrollments")
    public ResponseEntity<OutputEnrollStudentDTO> enroll(@RequestBody InputEnrollStudentDTO input) {
        final var output = enrollStudentUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    //    TODO: Remove this
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    @PreAuthorize("hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN')")
    @GetMapping
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }
}
