package com.jisrael.services.users.configuration;

import com.jisrael.services.users.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsersExceptionHandler {

    @ExceptionHandler(UsersException.class)
    public ResponseEntity<ErrorResponse> defaultException(final UsersException ex) {
        var customResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity(customResponse, HttpStatus.resolve(ex.getCode()));
    }
}
