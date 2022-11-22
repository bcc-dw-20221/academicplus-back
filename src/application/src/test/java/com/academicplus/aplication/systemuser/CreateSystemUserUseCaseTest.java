package com.academicplus.aplication.systemuser;

import com.academicplus.domain.systemuser.Role;
import org.junit.jupiter.api.Test;

import java.util.List;

class CreateSystemUserUseCaseTest {
    private CreateSystemUserUseCase useCase;

    @Test
    void shouldCreateSystemUser() {
        final var identifier = "1";
        final var username = "user@email.com";
        final var password = "pass1234";
        final var roles = List.of(Role.ROLE_ADMIN);

        final var input = new InputCreateSystemUserDTO(identifier, username, password, roles);
        useCase.execute(input);
    }

}