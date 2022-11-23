package com.academicplus.infrastructure.api.systemuser;

import com.academicplus.aplication.student.InputEnrollStudentDTO;
import com.academicplus.aplication.student.OutputEnrollStudentDTO;
import com.academicplus.aplication.systemuser.CreateSystemUserUseCase;
import com.academicplus.aplication.systemuser.InputCreateSystemUserDTO;
import com.academicplus.aplication.systemuser.OutputCreateSystemUserDTO;
import com.academicplus.domain.systemuser.Role;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/system-users")
@Tag(name = "System User")
public class SystemUserController {
    private final CreateSystemUserUseCase createSystemUserUseCase;

    public SystemUserController(CreateSystemUserUseCase createSystemUserUseCase) {
        this.createSystemUserUseCase = createSystemUserUseCase;
    }

    @PreAuthorize("hasRole('ROLE_ROOT')")
    @PostMapping("/su")
    public ResponseEntity<OutputCreateSystemUserDTO> createSystemUser(@RequestBody InputCreateSystemUserDTO input) {
        final var output = this.createSystemUserUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

    @PreAuthorize("hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody InputCreateSystemUserDTO input) {
        if (input.roles().contains(Role.ROLE_ROOT))
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
        final var output = this.createSystemUserUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

}
