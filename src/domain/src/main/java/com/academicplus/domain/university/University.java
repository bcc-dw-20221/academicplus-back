package com.academicplus.domain.university;

import com.academicplus.domain.AggregateRoot;
import com.academicplus.domain.shared.Address;

import java.time.Instant;

public class University extends AggregateRoot<UniversityID> {
    private String name;
    private Address address;

    private University(
            final UniversityID universityID,
            final String name,
            final Address address,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(universityID, createdAt, updatedAt, deletedAt);
        this.name = name;
        this.address = address;
        this.validate();
    }

    public static University create(final UniversityID id, final String name, final Address address) {
        final var now = Instant.now();
        return new University(id, name, address, now, now, null);
    }

    public University update(
            final String name,
            final Address address
    ) {
        this.name = name;
        this.address = address;
        super.updatedAt = Instant.now();
        this.validate();
        return this;
    }

    @Override
    protected void validate() {

    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
