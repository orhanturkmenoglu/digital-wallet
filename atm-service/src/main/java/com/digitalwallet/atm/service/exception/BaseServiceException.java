package com.digitalwallet.atm.service.exception;

import org.springframework.http.HttpStatus;

public class BaseServiceException extends RuntimeException {

    private final HttpStatus status;

    public BaseServiceException(String message,HttpStatus httpStatus) {
        super(message);
        this.status = httpStatus;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
