package com.academicplus.domain.systemuser;

import com.academicplus.domain.Identifier;
import com.academicplus.domain.admin.AdminID;
import org.junit.jupiter.api.Test;

import java.util.List;

class SystemUserTest {

    @Test
    void shouldCreateASystemUser() {
        final Identifier identifier = AdminID.from("1");
        final var username = "user@email.com";
        final var password = "pass1234";
        final var roles = List.of(Role.ROLE_ADMIN);

        SystemUser.create(identifier, username, password, roles);
    }

}