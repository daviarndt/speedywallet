package com.speedywallet.speedywallet.utils.exception;

public class PayerIsPayeeException extends RuntimeException {
    public PayerIsPayeeException(String message) {
        super(message);
    }
}
