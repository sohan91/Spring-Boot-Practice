package com.crude.RestCRUD.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> requestHandler(Exception e)
    {
        CustomExceptionMessage exception = new CustomExceptionMessage();
        exception.setStatus(HttpStatus.NOT_FOUND.value());
        exception.setMessage(e.getMessage());
        exception.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handler(Exception e)
    {
        CustomExceptionMessage exception = new CustomExceptionMessage();
        exception.setStatus(HttpStatus.BAD_REQUEST.value());
        exception.setMessage(e.getMessage());
        exception.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
    }
}
