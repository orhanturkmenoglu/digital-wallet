package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;

public class ATMInvalidParametersException extends BaseServiceException {

    public ATMInvalidParametersException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
