package com.academicplus.domain.user;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Genre;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void shouldCreateAUser() {
        final var userId = UserID.from("1");
        final var name = "Gibu";
        final var cpf = "111.111.111-85";
        final var sex = Genre.MALE;
        final var motherName = "Giboia";
        final var email = "gibu@email.com";
        final var birthDate = LocalDate.parse("1999-09-29");
        final var address = new Address("Street 1", "12A", "62800-000");
        final User user = User.create(userId, name, cpf, sex, motherName, email, birthDate, address);

        assertEquals(userId, user.getId());
        assertEquals(name, user.getName());
        assertEquals(cpf, user.getCpf());
        assertEquals(sex, user.getSex());
        assertEquals(motherName, user.getMotherName());
        assertEquals(email, user.getEmail());
        assertEquals(birthDate, user.getBirthDate());
        assertEquals(address, user.getAddress());
    }

}