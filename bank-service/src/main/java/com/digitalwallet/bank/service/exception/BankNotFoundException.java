package com.digitalwallet.bank.service.exception;

public class BankNotFoundException extends RuntimeException {

    public BankNotFoundException(String message) {
        super(message);
    }
}
