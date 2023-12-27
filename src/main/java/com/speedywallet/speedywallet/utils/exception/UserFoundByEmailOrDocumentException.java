package com.speedywallet.speedywallet.utils.exception;

public class UserFoundByEmailOrDocumentException extends RuntimeException {
    public UserFoundByEmailOrDocumentException(String message) {
        super(message);
    }
}
