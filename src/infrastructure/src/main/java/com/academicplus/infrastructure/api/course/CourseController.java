package com.academicplus.infrastructure.api.course;

import com.academicplus.aplication.course.CreateCourseUseCase;
import com.academicplus.aplication.course.InputCreateCourseDTO;
import com.academicplus.aplication.course.OutputCreateCourseDTO;
import com.academicplus.domain.course.Course;
import com.academicplus.domain.course.CourseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/courses")
@Tag(name = "Course")
public class CourseController {
    private final CreateCourseUseCase createCourseUseCase;

    public CourseController(
            final CreateCourseUseCase createCourseUseCase
    ) {
        this.createCourseUseCase = Objects.requireNonNull(createCourseUseCase);
    }

    @PostMapping
    @Operation(summary = "Create new course")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<OutputCreateCourseDTO> create(@RequestBody InputCreateCourseDTO input) {
        final var output = this.createCourseUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

//    TODO: remove this
    @Autowired
    private CourseRepository courseRepository;
    @GetMapping
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
