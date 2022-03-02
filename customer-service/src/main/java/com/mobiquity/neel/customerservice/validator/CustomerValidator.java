package com.mobiquity.neel.customerservice.validator;

import com.mobiquity.neel.customerservice.exception.ValidationFailedException;
import com.mobiquity.neel.customerservice.util.Properties;
import openapi.model.CreateCustomerRequestDto;
import openapi.model.PatchCustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static com.mobiquity.neel.customerservice.util.Constants.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Component
public class CustomerValidator {

    @Autowired
    Properties properties;

    public String validateIdAndUserName(String id, String userName) {
        return "" + (isValid(id) ? '1' : '0') + (isValid(userName) ? '1' : '0');
    }

    private boolean isValid(Object value) {
        return Objects.nonNull(value) && (!value.toString().trim().isEmpty());
    }

    public void validateCreateCustomerRequestDto(CreateCustomerRequestDto createCustomerRequestDto) {
        validatePattern(createCustomerRequestDto.getPhoneNumber(),properties.getPhoneRegEx(),CUS_CREATE_PHONE_NUMBER_NOT_VALID_CODE,CUS_CREATE_PHONE_NUMBER_NOT_VALID_DESCRIPTION);
        validatePattern(createCustomerRequestDto.getEmail(),properties.getEmailRegEx(),CUS_CREATE_EMAIL_NOT_VALID_CODE,CUS_CREATE_EMAIL_NOT_VALID_DESCRIPTION);
        validatePattern(createCustomerRequestDto.getUserName(), properties.getUserNameRegEx(),CUS_CREATE_USERNAME_NOT_VALID_CODE,CUS_CREATE_USERNAME_NOT_VALID_DESCRIPTION );
    }

    private void validatePattern(String value, String pattern, String errorCode, String errorDescription){
        if(!value.matches(pattern)){
            throw new ValidationFailedException(errorCode,errorDescription,BAD_REQUEST);
        }
    }

    public void validatePatchCustomerRequestDto(PatchCustomerRequestDto patchCustomerRequestDto) {
        if(Objects.isNull(patchCustomerRequestDto)){
            return;
        }
        removeEmpty(patchCustomerRequestDto);
        if(patchCustomerRequestDto.getPhoneNumber() != null) validatePattern(patchCustomerRequestDto.getPhoneNumber(),properties.getPhoneRegEx(),CUS_UPDATE_PHONE_NUMBER_NOT_VALID_CODE,CUS_UPDATE_PHONE_NUMBER_NOT_VALID_DESCRIPTION);
        if(patchCustomerRequestDto.getEmail() != null) validatePattern(patchCustomerRequestDto.getEmail(),properties.getEmailRegEx(),CUS_UPDATE_EMAIL_NOT_VALID_CODE,CUS_UPDATE_EMAIL_NOT_VALID_DESCRIPTION);
    }

    private void removeEmpty(PatchCustomerRequestDto patchCustomerRequestDto) {
        if(!isValid(patchCustomerRequestDto.getEmail())){
            patchCustomerRequestDto.setEmail(null);
        }
        if(!isValid(patchCustomerRequestDto.getPhoneNumber())){
            patchCustomerRequestDto.setPhoneNumber(null);
        }
        if(!isValid(patchCustomerRequestDto.getFirstName())){
            patchCustomerRequestDto.setFirstName(null);
        }
        if(!isValid(patchCustomerRequestDto.getLastName())){
            patchCustomerRequestDto.setLastName(null);
        }
    }

    public void validateUserName(String username) {
        if(!isValid(username)){
            throw new ValidationFailedException(CUS_UPDATE_MANDATORY_FIELD_NOT_VALID_CODE,CUS_UPDATE_MANDATORY_FIELD_NOT_VALID_DESCRIPTION,BAD_REQUEST);
        }
    }
}
