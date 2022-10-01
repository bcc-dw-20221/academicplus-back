package com.academicplus.aplication.user.create;

import com.academicplus.domain.exception.DomainException;
import com.academicplus.domain.user.User;
import com.academicplus.domain.user.UserID;
import com.academicplus.domain.user.UserRepository;

import java.util.Objects;

public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(final UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository);
    }

    public CreateUserOutputDTO execute(final CreateUserInputDTO input) {
        final User user = buildUser(input);
        final var exists = verifyIfUserAlreadyExists(user);
        if (exists)
            throw new DomainException("User Already exists");
        this.userRepository.create(user);
        return buildOutput(user);
    }

    private User buildUser(final CreateUserInputDTO input) {
        return User.create(
                UserID.unique(),
                input.name(),
                input.cpf(),
                input.sex(),
                input.motherName(),
                input.email(),
                input.birthDate(),
                input.address()
        );
    }

    private boolean verifyIfUserAlreadyExists(final User user) {
        final var existsById = Objects.nonNull(this.userRepository.findById(user.getId()));
        final var existsByCpf = Objects.nonNull(this.userRepository.findByCpf(user.getCpf()));
        return (existsById || existsByCpf);
    }

    private CreateUserOutputDTO buildOutput(final User user) {
        return new CreateUserOutputDTO(
                user.getId().getValue(),
                user.getName(),
                user.getCpf(),
                user.getSex(),
                user.getMotherName(),
                user.getEmail(),
                user.getBirthDate(),
                user.getAddress()
        );
    }
}
