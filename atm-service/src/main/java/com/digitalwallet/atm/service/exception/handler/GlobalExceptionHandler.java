package com.digitalwallet.atm.service.exception.handler;

import com.digitalwallet.atm.service.exception.*;
import jakarta.validation.ValidationException;
import org.digitalwallet.common.exception.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(ValidationException validationException) {
        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode(validationException.getMessage())
                .message("VALIDATION_ERROR")
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception,
                                                                   WebRequest request) {
        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder message = new StringBuilder("Validation failed: ");

        for (FieldError error : bindingResult.getFieldErrors()) {
            message.append(error.getField())
                    .append("-")
                    .append(error.getRejectedValue())
                    .append(error.getDefaultMessage())
                    .append("; ");
        }

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode(message.toString())
                .message("Validation_ERROR ")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ATMInvalidParametersException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidATMParametersException(ATMInvalidParametersException invalidATMParametersException,
                                                                                WebRequest request) {

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode(invalidATMParametersException.getMessage())
                .message("INVALID_ATM_PARAMETERS")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ATMNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleATMNotFoundException(ATMNotFoundException atmNotFoundException,
                                                                       WebRequest request) {

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode(atmNotFoundException.getMessage())
                .message("ATM_NOT_FOUND")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ATMServiceCodeInvalidParameterException.class)
    public ResponseEntity<ApiErrorResponse> handleATMServiceCodeInvalidParameterException(ATMServiceCodeInvalidParameterException invalidParameterException,
                                                                       WebRequest request) {

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode(invalidParameterException.getMessage())
                .message("INVALID_ATM_SERVICE_CODE")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ATMServiceCodeNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleATMServiceCodeNotFoundException(ATMServiceCodeNotFoundException atmServiceCodeNotFoundException,
                                                                       WebRequest request) {

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode(atmServiceCodeNotFoundException.getMessage())
                .message("ATM_SERVICE_CODE_NOT_FOUND")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(AddressInvalidParameterException.class)
    public ResponseEntity<ApiErrorResponse> handleAddressInvalidParameterException(AddressInvalidParameterException invalidParameterException,
                                                                                   WebRequest request) {

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode(invalidParameterException.getMessage())
                .message("ATM_SERVICE_CODE_NOT_FOUND")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleAddressNotFoundException(AddressNotFoundException addressNotFoundException,
                                                                           WebRequest request) {

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode(addressNotFoundException.getMessage())
                .message("ATM_SERVICE_CODE_NOT_FOUND")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(LocationInvalidParameterException.class)
    public ResponseEntity<ApiErrorResponse> handleLocationInvalidParameterException(LocationInvalidParameterException invalidParameterException,
                                                                                    WebRequest request) {

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode(invalidParameterException.getMessage())
                .message("LOCATION_INVALID_PARAMETER")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleLocationNotFoundException(LocationNotFoundException locationNotFoundException,
                                                                            WebRequest request) {

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode(locationNotFoundException.getMessage())
                .message("LOCATION_NOT_FOUND")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.NOT_FOUND);
    }


}
