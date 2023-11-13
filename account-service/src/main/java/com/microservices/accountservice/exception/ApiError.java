package com.microservices.accountservice.exception;

import lombok.Getter;

@Getter
public class ApiError {
    private String message;

    public ApiError(String message) {
        super();
        this.message = message;
    }
}
