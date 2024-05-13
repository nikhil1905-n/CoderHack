package com.nikhiln.coderHack.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String DEFAULT_MSG = "User Not Found";

    public UserNotFoundException() {
        super(DEFAULT_MSG);
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
    
}
