package com.academicplus.infrastructure.repository;

import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.systemuser.Role;
import com.academicplus.domain.systemuser.SystemUser;
import com.academicplus.domain.systemuser.SystemUserID;
import com.academicplus.domain.systemuser.SystemUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SystemUserRepositoryMemory implements SystemUserRepository {
    private static final List<SystemUser> systemUsers = new ArrayList<>();

    static {
        final var systemUser = new SystemUser(SystemUserID.from("1"), "root", "$2a$10$elFJbFh018hRjzc8OdfhBekW5wFDrBvDdoyHWUio7pRuv5xLxFXe.", List.of(Role.ROLE_ROOT));
        systemUsers.add(systemUser);
    }

    @Override
    public SystemUser create(SystemUser systemUser) {
        systemUsers.add(systemUser);
        return systemUser;
    }

    @Override
    public List<SystemUser> findAll() {
        return systemUsers;
    }

    @Override
    public Optional<SystemUser> findByUsername(String username) {
        return systemUsers.stream().filter(u -> u.getUsername().equals(username)).findFirst();
    }

    @Override
    public boolean existsByUsername(String username) {
        return systemUsers.stream().anyMatch(u -> u.getUsername().equals(username));
    }
}
