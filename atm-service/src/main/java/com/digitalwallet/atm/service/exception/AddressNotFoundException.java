package com.digitalwallet.atm.service.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class AddressNotFoundException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public AddressNotFoundException(String message) {
        super(message);
        this.status = HttpStatus.NOT_FOUND;
        this.message = message;
    }
}
