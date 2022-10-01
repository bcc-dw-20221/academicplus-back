package com.academicplus.aplication.person;

import com.academicplus.aplication.shared.AddressDTO;
import com.academicplus.domain.shared.Genre;

import java.time.LocalDate;

public record OutputCreatePersonDTO(
        String id,
        String name,
        String cpf,
        Genre sex,
        String motherName,
        String email,
        LocalDate birthDate,
        AddressDTO address
) {
}
