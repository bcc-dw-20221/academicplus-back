package com.academicplus.aplication.user.find;

import com.academicplus.domain.user.User;
import com.academicplus.domain.user.UserID;
import com.academicplus.domain.user.UserRepository;

import java.util.Objects;

public class FindUserByIdUseCase {
    private final UserRepository userRepository;

    public FindUserByIdUseCase(UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository);
    }

    public FindUserOutputDTO execute(final String id) {
        final var user = this.userRepository.findById(UserID.from(id));
        return buildOutput(user);
    }

    private FindUserOutputDTO buildOutput(final User user) {
        return new FindUserOutputDTO(
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
