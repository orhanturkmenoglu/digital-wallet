package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;


public class LocationInvalidParameterException extends BaseServiceException {

    public LocationInvalidParameterException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
