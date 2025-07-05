package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<StudentErrorResponse> studentResponse(StudentNotFoundException error)
    {
        StudentErrorResponse exception = new StudentErrorResponse();
        exception.setStatus(HttpStatus.NOT_FOUND.value());
        exception.setMessage(error.getMessage());
        exception.setTime(System.currentTimeMillis());
        return new ResponseEntity<>(exception,HttpStatus.NOT_FOUND);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleResponse(Exception e)
    {
        StudentErrorResponse exception = new StudentErrorResponse();
        exception.setStatus(HttpStatus.BAD_REQUEST.value());
        exception.setMessage(e.getMessage());
        exception.setTime(System.currentTimeMillis());
        return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
    }
}
