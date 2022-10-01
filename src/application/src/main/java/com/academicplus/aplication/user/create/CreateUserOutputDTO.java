package com.academicplus.aplication.user.create;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Genre;

import java.time.LocalDate;

public record CreateUserOutputDTO(
        String id,
        String name,
        String cpf,
        Genre sex,
        String motherName,
        String email,
        LocalDate birthDate,
        Address address
) {
}
