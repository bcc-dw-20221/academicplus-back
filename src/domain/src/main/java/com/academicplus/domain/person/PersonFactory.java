package com.academicplus.domain.person;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Gender;

import java.time.LocalDate;

public class PersonFactory {
    public static Person createWithAddress(String name, String cpf, Gender gender, String motherName, String email, LocalDate birthDate, Address address) {
        return Person.create(name, cpf, gender, motherName, email, birthDate, address);
    }
}
