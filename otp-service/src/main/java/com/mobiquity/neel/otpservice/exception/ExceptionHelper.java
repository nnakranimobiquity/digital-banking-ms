package com.mobiquity.neel.otpservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;


import static com.mobiquity.neel.otpservice.util.Constants.*;


public class ExceptionHelper {

    private ExceptionHelper() {
    }

    public static ValidationFailedException getValidationFailedException(MethodArgumentNotValidException ex) {
        ValidationFailedException validationFailedException = new ValidationFailedException();
        String objectName = ex.getAllErrors().get(0).getObjectName();

        if(objectName.contains("ValidateOtpRequestDto")) {
            validationFailedException = new ValidationFailedException(OTP_VAL_PROVIDED_OTP_NULL_CODE, OTP_VAL_PROVIDED_OTP_NULL_DESCRIPTION, HttpStatus.BAD_REQUEST);
        }
        return validationFailedException;
    }
}
