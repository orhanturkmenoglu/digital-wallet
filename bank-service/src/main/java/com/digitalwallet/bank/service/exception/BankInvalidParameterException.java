package com.digitalwallet.bank.service.exception;

public class BankInvalidParameterException extends RuntimeException {
    public BankInvalidParameterException(String message) {
        super(message);
    }
}
