package com.academicplus.infrastructure.api;

import com.academicplus.domain.exception.DomainException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = DomainException.class)
    public ResponseEntity<?> handleDomainException(final DomainException ex) {
        return ResponseEntity.badRequest().body(ApiError.from(ex));
    }

    private record ApiError(String message) {
        static ApiError from(final DomainException ex) {
            return new ApiError(ex.getMessage());
        }
    }
}
