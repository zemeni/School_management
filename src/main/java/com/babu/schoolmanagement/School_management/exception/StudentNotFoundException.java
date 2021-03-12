package com.babu.schoolmanagement.School_management.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(){

    }

    public StudentNotFoundException(String message){
        super(message);
    }
}
