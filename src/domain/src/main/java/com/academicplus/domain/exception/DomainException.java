package com.academicplus.domain.exception;

public class DomainException extends NoStackTraceException {
    public DomainException(final String message) {
        super(message);
    }
}
