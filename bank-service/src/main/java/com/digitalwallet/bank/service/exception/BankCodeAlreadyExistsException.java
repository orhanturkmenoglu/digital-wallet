package com.digitalwallet.bank.service.exception;

public class BankCodeAlreadyExistsException extends RuntimeException {
    public BankCodeAlreadyExistsException(String message) {
        super(message);
    }
}
