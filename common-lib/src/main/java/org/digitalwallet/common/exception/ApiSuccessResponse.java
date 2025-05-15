package org.digitalwallet.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiSuccessResponse<T> {

    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String message;
    private T data;

}
