package com.academicplus.aplication.user.find;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Gender;

import java.time.LocalDate;

public record FindUserOutputDTO(
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
