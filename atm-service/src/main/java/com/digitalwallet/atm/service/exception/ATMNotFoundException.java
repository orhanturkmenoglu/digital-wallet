package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;


public class ATMNotFoundException extends BaseServiceException {

    public ATMNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
