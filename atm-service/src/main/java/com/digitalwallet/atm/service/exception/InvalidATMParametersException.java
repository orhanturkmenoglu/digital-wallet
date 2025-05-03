package com.digitalwallet.atm.service.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class InvalidATMParametersException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public InvalidATMParametersException(String message) {
        super(message);
        this.message = message;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
