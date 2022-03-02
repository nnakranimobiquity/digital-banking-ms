package com.mobiquity.neel.customerservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;


@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        ex.printStackTrace();
        ExceptionResponse exceptionResponse = new ExceptionResponse("Internal Server Error.",ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationFailedException.class)
    public final ResponseEntity<ExceptionResponse> handleSecurityQuestionsLengthNotValidException(ValidationFailedException ex, WebRequest request){
        return new ResponseEntity<>(ex.toExceptionResponse(),ex.getHttpStatus());
    }

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<ExceptionResponse> handleValidationException(ValidationException ex, WebRequest request){
        ValidationFailedException validationFailedException = (ValidationFailedException) ex.getCause();
        return new ResponseEntity<>(validationFailedException.toExceptionResponse(),validationFailedException.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      ValidationFailedException validationFailedException = ExceptionHelper.getValidationFailedException(ex);
      return new ResponseEntity<>(validationFailedException.toExceptionResponse(),validationFailedException.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ValidationFailedException validationFailedException = ExceptionHelper.getValidationFailedException(ex);
        return new ResponseEntity<>(validationFailedException.toExceptionResponse(),validationFailedException.getHttpStatus());
    }
}
