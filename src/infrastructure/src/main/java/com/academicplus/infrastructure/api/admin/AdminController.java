package com.academicplus.infrastructure.api.admin;

import com.academicplus.aplication.admin.create.CreateAdminUseCase;
import com.academicplus.aplication.admin.create.InputCreateAdminDTO;
import com.academicplus.aplication.admin.create.OutputCreateAdminDTO;
import com.academicplus.domain.admin.Admin;
import com.academicplus.domain.admin.AdminRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/admins")
@Tag(name = "Admin")
public class AdminController {
    private final CreateAdminUseCase createAdminUseCase;

    public AdminController(CreateAdminUseCase createAdminUseCase) {
        this.createAdminUseCase = createAdminUseCase;
    }

    @PreAuthorize("hasAnyRole('ROLE_ROOT', 'ROLE_ADMIN')")
    @PostMapping
    @Operation(summary = "Register admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Create successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<OutputCreateAdminDTO> register(@RequestBody InputCreateAdminDTO input) {
        final var output = this.createAdminUseCase.execute(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(output);
    }

//    TODO: Remove this;
    @Autowired
    private AdminRepository adminRepository;
    @RolesAllowed("ROLE_ROOT")
    @GetMapping
    private List<Admin> findAll() {
        return adminRepository.findAll();
    }
}
