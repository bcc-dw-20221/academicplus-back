package com.academicplus.aplication.systemuser;

import com.academicplus.aplication.gateway.PasswordEncoder;
import com.academicplus.domain.Identifier;
import com.academicplus.domain.admin.AdminID;
import com.academicplus.domain.exception.DomainException;
import com.academicplus.domain.systemuser.SystemUser;
import com.academicplus.domain.systemuser.SystemUserID;
import com.academicplus.domain.systemuser.SystemUserRepository;

public class CreateSystemUserUseCase {
    private final SystemUserRepository systemUserRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateSystemUserUseCase(SystemUserRepository systemUserRepository, PasswordEncoder passwordEncoder) {
        this.systemUserRepository = systemUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public OutputCreateSystemUserDTO execute(InputCreateSystemUserDTO input) {
        final var identifier = SystemUserID.from(input.identifier());
        final var username = input.username();
        final var password = passwordEncoder.encode(input.password());
        final var roles = input.roles();
        final var systemUser = SystemUser.create(identifier, username, password, roles);

        final var existsByUsername = this.systemUserRepository.existsByUsername(username);
        if (existsByUsername)
            throw new DomainException("User already exists");

        this.systemUserRepository.create(systemUser);
        return new OutputCreateSystemUserDTO(systemUser.getUsername());
    }
}
