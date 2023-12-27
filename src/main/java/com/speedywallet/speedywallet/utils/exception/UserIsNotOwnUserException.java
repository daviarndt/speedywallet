package com.speedywallet.speedywallet.utils.exception;

public class UserIsNotOwnUserException extends RuntimeException {
    public UserIsNotOwnUserException(String message) {
        super(message);
    }
}
