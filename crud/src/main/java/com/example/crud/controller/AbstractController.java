package com.example.crud.controller;

import com.example.crud.dto.ErrorResponse;
import com.example.crud.service.exception.EmptyCollectionException;
import com.example.crud.service.exception.NotFoundByIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

import static com.example.crud.util.ResponseBuilder.buildErrorResponse;

public abstract class AbstractController {

    @ExceptionHandler(NotFoundByIdException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(NotFoundByIdException e) {
        return buildErrorResponse(e.getMessage(), 404);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
        return buildErrorResponse(e.getMessage(), 400);
    }

    @ExceptionHandler(EmptyCollectionException.class)
    public ResponseEntity handleEmptyCollectionException(EmptyCollectionException e) {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity handleNoSuchMethodException(NoSuchMethodException e) {
        return buildErrorResponse("invalid data type: "+ e.getMessage(), 400);
    }
}
