package com.academicplus.aplication.person.create;

import com.academicplus.aplication.shared.AddressDTO;
import com.academicplus.domain.person.Person;
import com.academicplus.domain.shared.Gender;

import java.time.LocalDate;

public record OutputCreatePersonDTO(
        String id,
        String name,
        String cpf,
        Gender sex,
        String motherName,
        String email,
        LocalDate birthDate,
        AddressDTO address
) {
    public static OutputCreatePersonDTO from(Person person) {
        return new OutputCreatePersonDTO(
                person.getId().getValue(),
                person.getName(),
                person.getCpf(),
                person.getGender(),
                person.getMotherName(),
                person.getEmail(),
                person.getBirthDate(),
                AddressDTO.from(person.getAddress())
        );
    }
}
