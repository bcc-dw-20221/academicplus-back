package com.academicplus.domain.admin;

import java.util.List;
import java.util.Optional;

public interface AdminRepository {
    Admin create(Admin admin);

    List<Admin> findAll(); //TODO: Remove this;

//    Optional<Admin> findByUsername(String username);
//
//    boolean existsByUsername(String username);
}
