package com.speedywallet.speedywallet.utils.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message){
        super(message);
    }
}
