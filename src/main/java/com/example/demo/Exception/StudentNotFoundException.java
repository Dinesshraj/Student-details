package com.example.demo.Exception;

@SuppressWarnings("serial")
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message) {
        super(message);
    }
}