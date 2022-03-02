package com.mobiquity.neel.customerservice.exception;

import org.springframework.http.HttpStatus;

public class ValidationFailedException extends RuntimeException{

    private final String errorCode;
    private final String errorDescription;
    private final HttpStatus httpStatus;
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public ValidationFailedException() {
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        errorCode = "UNKNOWN";
        errorDescription = "UNKNOWN";
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param errorDescription the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ValidationFailedException(String errorCode, String errorDescription,HttpStatus httpStatus) {
        super(errorDescription);
        this.errorCode =  errorCode;
        this.errorDescription = errorDescription;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }


    public ExceptionResponse toExceptionResponse(){
        return new ExceptionResponse(errorCode,errorDescription);
    }
}
