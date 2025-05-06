package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;

public class AddressNotFoundException extends BaseServiceException {

    public AddressNotFoundException(String message, HttpStatus status) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
