package com.digitalwallet.atm.service.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class InvalidAddressException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public InvalidAddressException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST;
        this.message = message;
    }
}
