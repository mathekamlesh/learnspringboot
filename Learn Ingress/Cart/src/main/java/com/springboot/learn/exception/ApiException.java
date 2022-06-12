package com.springboot.learn.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiException extends RuntimeException {
    private final String status;
    private final String message;
    private final String statusCode;
}
