package com.academicplus.domain;

import java.time.Instant;

public abstract class AggregateRoot<ID extends Identifier> extends Entity<ID> {
    protected final Instant createdAt;
    protected Instant updatedAt;
    protected Instant deletedAt;

    protected AggregateRoot(
            final ID id,
            final Instant createdAt,
            final Instant updatedAt,
            final Instant deletedAt
    ) {
        super(id);
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }
}
