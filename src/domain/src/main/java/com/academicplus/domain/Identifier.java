package com.academicplus.domain;

import java.util.Objects;

public abstract class Identifier extends ValueObject {
    private final String value;

    protected Identifier(final String value) {
        Objects.requireNonNull(value, "'value' can not be null");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
