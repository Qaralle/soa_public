package com.example.crud.service.exception;

public class NotFoundByIdException extends RuntimeException {
    public NotFoundByIdException(String errorMessage) {
        super(errorMessage);
    }
}
