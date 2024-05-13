package com.nikhiln.coderHack.exception;

public class UserAlreadyExistsException extends RuntimeException {

    private static final String DEFAULT_MSG = "User Already Exists";

    public UserAlreadyExistsException() {
        super(DEFAULT_MSG);
    }

    public UserAlreadyExistsException(String msg) {
        super(msg);
    }
    
}
