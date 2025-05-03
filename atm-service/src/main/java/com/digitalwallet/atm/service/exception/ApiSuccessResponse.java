package com.digitalwallet.atm.service.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiSuccessResponse<T> {

    private LocalDateTime timeStamp;
    private int status;
    private String message;
    private T data;
}
