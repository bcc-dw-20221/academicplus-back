package com.academicplus.aplication.admin.create;

import com.academicplus.aplication.gateway.PasswordEncoder;
import com.academicplus.domain.admin.Admin;
import com.academicplus.domain.admin.AdminID;
import com.academicplus.domain.admin.AdminRepository;
import com.academicplus.domain.person.PersonID;

public class CreateAdminUseCase {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateAdminUseCase(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public OutputCreateAdminDTO execute(InputCreateAdminDTO input) {
        final var adminID = AdminID.unique();
        final var personID = PersonID.from(input.personId());
        final var admin = Admin.create(adminID, personID);
        this.adminRepository.create(admin);
        return new OutputCreateAdminDTO(adminID.getValue(), admin.getPersonID().getValue());
    }
}
