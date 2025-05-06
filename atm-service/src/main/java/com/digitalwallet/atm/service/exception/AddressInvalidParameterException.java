package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;


public class AddressInvalidParameterException extends BaseServiceException {

    public AddressInvalidParameterException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
