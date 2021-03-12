package com.babu.schoolmanagement.School_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //add exception handler for customer not found exception
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(StudentNotFoundException exc) {
        CustomErrorResponse err = new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    //add exception handler for all
    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> handleException(Exception exc) {
        CustomErrorResponse err = new CustomErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
