package com.example.crud.util;

import com.example.crud.dto.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseBuilder {
    public static ResponseEntity<ErrorResponse> buildErrorResponse(String msg, int status){
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_XML);

        ErrorResponse response = new ErrorResponse();

        response.setMessage(msg);
        response.setTimeStamp(LocalDateTime.now());

        return ResponseEntity.status(status).headers(httpHeaders).body(response);
    }
}
