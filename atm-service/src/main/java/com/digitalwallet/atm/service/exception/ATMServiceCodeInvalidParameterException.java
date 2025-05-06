package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;


public class ATMServiceCodeInvalidParameterException extends BaseServiceException {

    public ATMServiceCodeInvalidParameterException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
