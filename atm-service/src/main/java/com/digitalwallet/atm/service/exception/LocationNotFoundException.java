package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;

public class LocationNotFoundException extends BaseServiceException {

    public LocationNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
