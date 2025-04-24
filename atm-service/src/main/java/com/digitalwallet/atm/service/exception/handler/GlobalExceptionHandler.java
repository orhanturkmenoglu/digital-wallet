package com.digitalwallet.atm.service.exception.handler;

import com.digitalwallet.atm.service.exception.ApiErrorResponse;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler
    public ResponseEntity<ApiErrorResponse> handleValidationErrors(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();
        StringBuilder message = new StringBuilder("Validation failed: ");

        for (FieldError error:bindingResult.getFieldErrors()){
            message.append(error.getField())
                    .append("-")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }

        ApiErrorResponse apiErrorResponse = ApiErrorResponse.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .errorCode(message.toString())
                .message("Validation_ERROR")
                .build();

        return new ResponseEntity<>(apiErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
