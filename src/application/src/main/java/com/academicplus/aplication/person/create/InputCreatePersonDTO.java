package com.academicplus.aplication.person.create;

import com.academicplus.aplication.shared.AddressDTO;
import com.academicplus.domain.shared.Gender;

import java.time.LocalDate;

public record InputCreatePersonDTO(
        String name,
        String cpf,
        Gender gender,
        String motherName,
        String email,
        LocalDate birthDate,
        AddressDTO address
) {
}
