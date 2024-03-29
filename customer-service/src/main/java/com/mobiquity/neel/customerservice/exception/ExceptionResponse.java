package com.mobiquity.neel.customerservice.exception;

public class ExceptionResponse {
    private String errorCode;
    private String description;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }
}
