package com.microservices.accountservice.exception;

public class ApiException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private final String code;
    private final String description;
    private final Integer statusCode;

    public ApiException(String code, String description, Integer statusCode) {
        super(description);
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
