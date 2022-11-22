package com.academicplus.aplication.admin.create;

import com.academicplus.aplication.shared.AddressDTO;
import com.academicplus.domain.person.Person;
import com.academicplus.domain.shared.Gender;

import java.time.LocalDate;

public record OutputCreateAdminDTO(
        String id,
        String name
) {
}
