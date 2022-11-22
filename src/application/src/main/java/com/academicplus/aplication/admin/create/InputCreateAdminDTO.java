package com.academicplus.aplication.admin.create;

import com.academicplus.domain.systemuser.Role;

import java.util.List;

public record InputCreateAdminDTO(
        String personId,
        String username,
        String password,
        List<Role> roles
) {
}
