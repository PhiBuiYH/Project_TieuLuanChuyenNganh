package com.tanphi.laptopshop.exception;

public class SendMailException extends RuntimeException{
    public SendMailException(String message) {
        super(message);
    }
}
