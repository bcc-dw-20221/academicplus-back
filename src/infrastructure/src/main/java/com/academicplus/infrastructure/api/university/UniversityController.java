package com.academicplus.infrastructure.api.university;

import com.academicplus.aplication.university.create.CreateUniversityUseCase;
import com.academicplus.aplication.university.create.InputCreateUniversityDTO;
import com.academicplus.aplication.university.create.OutputCreateUniversityDTO;
import com.academicplus.aplication.university.find.FindUniversityByIdUseCase;
import com.academicplus.aplication.university.find.OutputFindUniversityByIdDTO;
import com.academicplus.domain.university.University;
import com.academicplus.domain.university.UniversityRepository;
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
@RequestMapping("/universities")
@Tag(name = "University")
public class UniversityController {
    private final CreateUniversityUseCase createUniversityUseCase;
    private final FindUniversityByIdUseCase findUniversityByIdUseCase;

    public UniversityController(
            final CreateUniversityUseCase createUniversityUseCase,
            final FindUniversityByIdUseCase findUniversityByIdUseCase
    ) {
        this.createUniversityUseCase = Objects.requireNonNull(createUniversityUseCase);
        this.findUniversityByIdUseCase = Objects.requireNonNull(findUniversityByIdUseCase);
    }

    @PostMapping
    @Operation(summary = "Create new university")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<OutputCreateUniversityDTO> createUniversity(@RequestBody InputCreateUniversityDTO input) {
        final var output = this.createUniversityUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @GetMapping("/{universityId}")
    @Operation(summary = "Find university by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<OutputFindUniversityByIdDTO> findById(@PathVariable String universityId) {
        final var output = this.findUniversityByIdUseCase.execute(universityId);
        return ResponseEntity.ok(output);
    }


//    TODO: Remove this
    @Autowired  private UniversityRepository universityRepository;
    @GetMapping
    public List<University> findAll() {
        return universityRepository.findAll();
    }
}
