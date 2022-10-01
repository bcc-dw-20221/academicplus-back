package com.academicplus.domain.userv2;

import com.academicplus.domain.AggregateRoot;
import com.academicplus.domain.person.PersonID;

import java.time.Instant;

public class UserV2 extends AggregateRoot<UserV2ID> {
    private PersonID personID;
    private String username;
    private String password;

    private UserV2(
            final UserV2ID userV2ID,
            final String username,
            final String password,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(userV2ID, createdAt, updatedAt, deletedAt);
        this.username = username;
        this.password = password;
    }

    public static UserV2 create(final PersonID personID, final String username, final String password) {
        return null;
    }

    @Override
    protected void validate() {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
