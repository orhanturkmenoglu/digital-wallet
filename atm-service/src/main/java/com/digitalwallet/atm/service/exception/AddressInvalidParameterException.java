package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;


public class AddressInvalidParameterException extends BaseServiceException {

    public AddressInvalidParameterException(String message, HttpStatus status) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
