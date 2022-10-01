package com.academicplus.infrastructure.api.student;

import com.academicplus.aplication.student.EnrollStudentUseCase;
import com.academicplus.aplication.student.InputEnrollStudentDTO;
import com.academicplus.aplication.student.OutputEnrollStudentDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/students")
@Tag(name = "Student")
public class StudentController {
    private final EnrollStudentUseCase enrollStudentUseCase;

    public StudentController(final EnrollStudentUseCase enrollStudentUseCase) {
        this.enrollStudentUseCase = Objects.requireNonNull(enrollStudentUseCase);
    }

    @PostMapping("/enrollments")
    public ResponseEntity<OutputEnrollStudentDTO> enroll(@RequestBody InputEnrollStudentDTO input) {
        final var output = enrollStudentUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

}
