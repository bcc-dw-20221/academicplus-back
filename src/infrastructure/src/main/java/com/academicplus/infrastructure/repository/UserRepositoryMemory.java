package com.academicplus.infrastructure.repository;

import com.academicplus.domain.user.User;
import com.academicplus.domain.user.UserID;
import com.academicplus.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryMemory implements UserRepository {
    private static final List<User> users = new ArrayList<>();

    @Override
    public User create(final User user) {
        users.add(user);
        return user;
    }

    @Override
    public User findById(final UserID id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findByCpf(final String cpf) {
        return users.stream()
                .filter(u -> u.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }
}
