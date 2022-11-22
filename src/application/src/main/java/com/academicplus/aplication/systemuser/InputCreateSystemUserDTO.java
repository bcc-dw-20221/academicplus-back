package com.academicplus.aplication.systemuser;

import com.academicplus.domain.systemuser.Role;

import java.util.List;

public record InputCreateSystemUserDTO(
        String identifier,
        String username,
        String password,
        List<Role> roles
) {
}
