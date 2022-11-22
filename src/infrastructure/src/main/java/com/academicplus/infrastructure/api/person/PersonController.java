package com.academicplus.infrastructure.api.person;

import com.academicplus.aplication.person.create.CreatePersonUseCase;
import com.academicplus.aplication.person.create.InputCreatePersonDTO;
import com.academicplus.aplication.person.create.OutputCreatePersonDTO;
import com.academicplus.aplication.person.find.GetPersonByCpfUseCase;
import com.academicplus.aplication.person.find.OutputGetPersonByCpfDTO;
import com.academicplus.domain.person.Person;
import com.academicplus.domain.person.PersonRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pre-register")
@Tag(name = "Pre register")
public class PersonController {
    private final CreatePersonUseCase createPersonUseCase;
    private final GetPersonByCpfUseCase getPersonByCpfUseCase;

    public PersonController(CreatePersonUseCase createPersonUseCase, GetPersonByCpfUseCase getPersonByCpfUseCase) {
        this.createPersonUseCase = createPersonUseCase;
        this.getPersonByCpfUseCase = getPersonByCpfUseCase;
    }

    @PreAuthorize("hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN')")
    @PostMapping
    @Operation(summary = "Register personId")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<OutputCreatePersonDTO> create(@RequestBody InputCreatePersonDTO input) {
        final var output = this.createPersonUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @PreAuthorize("hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN')")
    @GetMapping("/{cpf}")
    @Operation(summary = "Get personId by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<OutputGetPersonByCpfDTO> getByCpf(@PathVariable String cpf) {
        final var output = this.getPersonByCpfUseCase.execute(cpf);
        return ResponseEntity.ok(output);
    }

//    TODO: Remove this
    @Autowired PersonRepository personRepository;
    @PreAuthorize("hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN')")
    @GetMapping
    public List<Person> findAll() {
        return personRepository.findAll();
    }
}
