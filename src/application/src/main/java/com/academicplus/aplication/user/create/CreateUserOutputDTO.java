package com.academicplus.aplication.user.create;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Gender;

import java.time.LocalDate;

public record CreateUserOutputDTO(
        String id,
        String name,
        String cpf,
        Gender sex,
        String motherName,
        String email,
        LocalDate birthDate,
        Address address
) {
}
