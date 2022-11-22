package com.academicplus.domain.admin;

import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.systemuser.Role;
import org.junit.jupiter.api.Test;

class AdminTest {

    @Test
    void shouldCreateAdmin() {
        final var adminID = AdminID.from("1");
        final var personID = PersonID.from("1");
        final var username = "username";
        final var password = "pass";

        final var admin = Admin.create(adminID, personID, username, password);
        admin.addRole(Role.ROLE_ROOT);

    }
}