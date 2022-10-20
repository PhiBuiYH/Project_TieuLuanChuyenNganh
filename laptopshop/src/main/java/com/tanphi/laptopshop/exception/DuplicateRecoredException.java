package com.tanphi.laptopshop.exception;

public class DuplicateRecoredException extends RuntimeException{
    public DuplicateRecoredException(String message) {
        super(message);
    }
}
