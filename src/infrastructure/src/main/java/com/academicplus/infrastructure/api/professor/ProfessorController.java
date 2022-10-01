package com.academicplus.infrastructure.api.professor;

import com.academicplus.aplication.professor.CreateProfessorUseCase;
import com.academicplus.aplication.professor.InputRegisterProfessorDTO;
import com.academicplus.aplication.professor.OutputRegisterProfessorDTO;
import com.academicplus.domain.professor.Professor;
import com.academicplus.domain.professor.ProfessorRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
@Tag(name = "Professor")
public class ProfessorController {
    private final CreateProfessorUseCase createProfessorUseCase;

    public ProfessorController(CreateProfessorUseCase createProfessorUseCase) {
        this.createProfessorUseCase = createProfessorUseCase;
    }

    @PostMapping
    @Operation(summary = "Register professor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<OutputRegisterProfessorDTO> register(@RequestBody InputRegisterProfessorDTO input) {
        final var output = this.createProfessorUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

//    TODO: Remove this;
    @Autowired
    private ProfessorRepository professorRepository;
    @GetMapping
    private List<Professor> findAll() {
        return professorRepository.findAll();
    }
}
