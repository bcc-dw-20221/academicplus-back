package com.academicplus.infrastructure.repository;

import com.academicplus.domain.admin.Admin;
import com.academicplus.domain.admin.AdminID;
import com.academicplus.domain.admin.AdminRepository;
import com.academicplus.domain.person.PersonID;
import com.academicplus.domain.systemuser.Role;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepositoryMemory implements AdminRepository {
    private static final List<Admin> admins = new ArrayList<>();

    @Override
    public Admin create(Admin admin) {
        admins.add(admin);
        return admin;
    }

    @Override
    public List<Admin> findAll() {
        return admins;
    }
}
