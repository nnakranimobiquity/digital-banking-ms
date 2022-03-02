package com.mobiquity.neel.customerservice.exception;

import openapi.model.CreateCustomerRequestDto;
import openapi.model.PatchCustomerRequestDto;
import openapi.model.PreferredLanguageDto;
import openapi.model.StatusDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Objects;

import static com.mobiquity.neel.customerservice.util.Constants.*;
import static org.springframework.http.HttpStatus.*;

public class ExceptionHelper {

    private ExceptionHelper() {
    }

    public static ValidationFailedException getValidationFailedException(MethodArgumentNotValidException ex) {
        ValidationFailedException validationFailedException = new ValidationFailedException();
        String objectName = ex.getAllErrors().get(0).getObjectName();

        if(objectName.contains("ValidateOtpRequestDto")){
            validationFailedException  = new ValidationFailedException(OTP_VAL_PROVIDED_OTP_NULL_CODE, OTP_VAL_PROVIDED_OTP_NULL_DESCRIPTION, HttpStatus.BAD_REQUEST);
        }else if(objectName.contains("createCustomerRequestDto")){
            validationFailedException = new ValidationFailedException(CUS_CREATE_MANDATORY_FIELD_NOT_VALID_CODE,CUS_CREATE_MANDATORY_FIELD_NOT_VALID_DESCRIPTION, BAD_REQUEST);
        }
        else if(objectName.contains("createCustomerSecurityQuestionsRequestDto")){
                validationFailedException = new ValidationFailedException(SECURITY_QUESTIONS_LENGTH_NOT_VALID_CODE, SECURITY_QUESTIONS_LENGTH_NOT_VALID_DESCRIPTION, BAD_REQUEST);
        }
        return validationFailedException;
    }

    public static ValidationFailedException getValidationFailedException(HttpMessageNotReadableException ex) {
        String message = Objects.requireNonNull(ex.getMessage());
        return getValidationFailedException(message);
    }

    private static ValidationFailedException getValidationFailedException(String message) {

        if(message.contains(PreferredLanguageDto.class.getName())){
            if (message.contains(CreateCustomerRequestDto.class.getName())) {
                return new ValidationFailedException(CUS_CREATE_PREFERRED_LANGUAGE_NOT_VALID_CODE, CUS_CREATE_PREFERRED_LANGUAGE_NOT_VALID_DESCRIPTION, HttpStatus.BAD_REQUEST);
            }
            else if (message.contains(PatchCustomerRequestDto.class.getName())) {
                return new ValidationFailedException(CUS_UPDATE_PREFERRED_LANGUAGE_NOT_VALID_CODE, CUS_UPDATE_PREFERRED_LANGUAGE_NOT_VALID_DESCRIPTION, HttpStatus.BAD_REQUEST);
            }
        }
        else if(message.contains(StatusDto.class.getName())){
            return new ValidationFailedException(CUS_UPDATE_PREFERRED_LANGUAGE_NOT_VALID_CODE, CUS_UPDATE_PREFERRED_LANGUAGE_NOT_VALID_DESCRIPTION, HttpStatus.BAD_REQUEST);
        }
        return new ValidationFailedException();
    }
}
