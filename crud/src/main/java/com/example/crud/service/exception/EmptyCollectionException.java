package com.example.crud.service.exception;

public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException(String errorMessage) {
        super(errorMessage);
    }
}
