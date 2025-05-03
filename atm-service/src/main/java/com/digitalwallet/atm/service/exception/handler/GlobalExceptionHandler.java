package com.digitalwallet.atm.service.exception.handler;

import com.digitalwallet.atm.service.exception.ATMNotFoundException;
import com.digitalwallet.atm.service.exception.ApiErrorResponse;
import com.digitalwallet.atm.service.exception.InvalidATMParametersException;
import jakarta.validation.ValidationException;
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
    public ResponseEntity<ApiErrorResponse> handleValidationException(ValidationException validationException){
       ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
               .timeStamp(LocalDateTime.now())
               .status(HttpStatus.BAD_REQUEST.value())
               .errorCode(validationException.getMessage())
               .message("VALIDATION_ERROR")
               .build();

       return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidATMParametersException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidATMParametersException(InvalidATMParametersException invalidATMParametersException,
                                                                                WebRequest request){

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
                                                                       WebRequest request){

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode(atmNotFoundException.getMessage())
                .message("ATM_NOT_FOUND")
                .path(request.getDescription(false))
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception,
                                                                   WebRequest request){
        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder message = new StringBuilder("Validation failed: ");

        for (FieldError error:bindingResult.getFieldErrors()){
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
}
