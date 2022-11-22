package com.academicplus.aplication.person.find;

import com.academicplus.aplication.shared.AddressDTO;
import com.academicplus.domain.person.Person;
import com.academicplus.domain.shared.Gender;

import java.time.LocalDate;

public record OutputGetPersonByCpfDTO(
        String id,
        String name,
        String cpf,
        Gender gender,
        String motherName,
        String email,
        LocalDate birthDate,
        AddressDTO address
) {
    public static OutputGetPersonByCpfDTO from(final Person person) {
        return new OutputGetPersonByCpfDTO(
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
