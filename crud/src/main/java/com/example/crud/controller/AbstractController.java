package com.example.crud.controller;

import com.example.crud.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

import static com.example.crud.util.ResponseBuilder.buildErrorResponse;

public abstract class AbstractController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        return buildErrorResponse(e.getMessage(), 404);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException e) {
        return buildErrorResponse(e.getMessage(), 400);
    }

}
