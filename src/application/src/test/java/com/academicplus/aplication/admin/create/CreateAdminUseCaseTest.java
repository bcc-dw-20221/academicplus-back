package com.academicplus.aplication.admin.create;

import com.academicplus.domain.admin.AdminID;
import com.academicplus.domain.person.PersonID;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateAdminUseCaseTest {

    private CreateAdminUseCase useCase;

    @Test
    void shouldCreateAdmin() {
        final var input = new InputCreateAdminDTO("1", "username", "pass");
        useCase.execute(input);
    }

}