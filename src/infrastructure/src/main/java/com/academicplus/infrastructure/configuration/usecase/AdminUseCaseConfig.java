package com.academicplus.infrastructure.configuration.usecase;

import com.academicplus.aplication.admin.create.CreateAdminUseCase;
import com.academicplus.aplication.gateway.PasswordEncoder;
import com.academicplus.aplication.professor.CreateProfessorUseCase;
import com.academicplus.domain.admin.AdminRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminUseCaseConfig {
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminUseCaseConfig(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Bean
    public CreateAdminUseCase createAdminUseCase() {
        return new CreateAdminUseCase(adminRepository, passwordEncoder);
    }
}
