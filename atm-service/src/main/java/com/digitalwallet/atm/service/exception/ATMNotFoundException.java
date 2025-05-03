package com.digitalwallet.atm.service.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ATMNotFoundException extends RuntimeException {

    private HttpStatus status;
    private String message;


    public ATMNotFoundException(String message) {
        super(message);
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }
}
