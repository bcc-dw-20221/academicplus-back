package com.academicplus.domain.systemuser;

import java.util.List;
import java.util.Optional;

public interface SystemUserRepository {
    SystemUser create(SystemUser systemUser);

    List<SystemUser> findAll(); //TODO: Remove this;

    Optional<SystemUser> findByUsername(String username);

    boolean existsByUsername(String username);
}
