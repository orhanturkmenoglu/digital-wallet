package org.digitalwallet.common.exception;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Builder
public class ApiSuccessResponse<T> {

    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String message;
    private T data;

    public ApiSuccessResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }

    public ApiSuccessResponse(HttpStatus status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.timeStamp = LocalDateTime.now();
    }

}
