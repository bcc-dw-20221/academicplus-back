package com.academicplus.aplication.user.find;

import com.academicplus.domain.shared.Address;
import com.academicplus.domain.shared.Genre;
import com.academicplus.domain.user.User;
import com.academicplus.domain.user.UserID;
import com.academicplus.domain.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class FindUserByIdUseCaseTest {
    @InjectMocks
    private FindUserByIdUseCase useCase;
    @Mock
    private UserRepository userRepository;

    @Test
    void shouldGetUserById() {
        final var userId = UserID.from("1");
        final var name = "Gibu";
        final var cpf = "111.111.111-85";
        final var sex = Genre.MALE;
        final var motherName = "Giboia";
        final var email = "gibu@email.com";
        final var birthDate = LocalDate.parse("1999-09-29");
        final var address = new Address("Street 1", "12A", "62800-000");
        final User user = User.create(userId, name, cpf, sex, motherName, email, birthDate, address);

        doReturn(user).when(userRepository).findById(eq(UserID.from("1")));

        final var output = useCase.execute( "1");

        assertNotNull(output.id());
        assertEquals(name, output.name());
        assertEquals(cpf, output.cpf());
        assertEquals(sex, output.sex());
        assertEquals(motherName, output.motherName());
        assertEquals(email, output.email());
        assertEquals(birthDate, output.birthDate());
        assertEquals(address, output.address());
    }

}