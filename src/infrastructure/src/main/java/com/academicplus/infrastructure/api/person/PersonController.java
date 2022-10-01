package com.academicplus.infrastructure.api.person;

import com.academicplus.aplication.person.CreatePersonUseCase;
import com.academicplus.aplication.person.InputCreatePersonDTO;
import com.academicplus.aplication.person.OutputCreatePersonDTO;
import com.academicplus.domain.person.Person;
import com.academicplus.domain.person.PersonRepository;
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
@RequestMapping("/pre-register")
@Tag(name = "Pre register")
public class PersonController {
    private final CreatePersonUseCase createPersonUseCase;

    public PersonController(final CreatePersonUseCase createPersonUseCase) {
        this.createPersonUseCase = Objects.requireNonNull(createPersonUseCase);
    }

    @PostMapping
    @Operation(summary = "Register person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<OutputCreatePersonDTO> create(@RequestBody InputCreatePersonDTO input) {
        final var output = this.createPersonUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

//    TODO: Remove this
    @Autowired PersonRepository personRepository;
    @GetMapping
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
