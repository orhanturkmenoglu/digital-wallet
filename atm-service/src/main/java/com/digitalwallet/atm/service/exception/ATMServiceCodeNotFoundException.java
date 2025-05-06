package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;


public class ATMServiceCodeNotFoundException extends BaseServiceException {

    public ATMServiceCodeNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
