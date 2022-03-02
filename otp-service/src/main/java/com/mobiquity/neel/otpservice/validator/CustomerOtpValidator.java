package com.mobiquity.neel.otpservice.validator;

import com.mobiquity.neel.otpservice.entity.CustomerOtp;
import com.mobiquity.neel.otpservice.exception.ValidationFailedException;
import com.mobiquity.neel.otpservice.util.Properties;
import openapi.model.ValidateOtpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.mobiquity.neel.otpservice.util.Constants.*;

@Component
public class CustomerOtpValidator {

    private Properties properties;

    @Autowired
    public CustomerOtpValidator(Properties properties) {
        this.properties = properties;
    }


    public void validateOtpRequestDto(ValidateOtpRequestDto validateOtpRequestDto) {
        if(Objects.isNull(validateOtpRequestDto) ||  validateOtpRequestDto.getOtp().isEmpty() || validateOtpRequestDto.getUserName().isEmpty()){
            throw new ValidationFailedException(OTP_VAL_PROVIDED_OTP_NULL_CODE,OTP_VAL_PROVIDED_OTP_NULL_DESCRIPTION, HttpStatus.BAD_REQUEST);
        }
    }

    public boolean validateOtpWithSystemInitiatedOtp(ValidateOtpRequestDto validateOtpRequestDto, CustomerOtp customerOtp) {
        validateOtpFailedAttempt(customerOtp.getOptRetires());

        validateOtpExpiryTime(customerOtp.getExpiresOn());

        return validateOtpValue(validateOtpRequestDto.getOtp(),customerOtp);
    }

    private boolean validateOtpValue(String userProvidedOtpValue, CustomerOtp customerOtp) {
        String systemGeneratedOtp = customerOtp.getOtp();

        return userProvidedOtpValue.trim().equalsIgnoreCase(systemGeneratedOtp.trim());
    }

    private void validateOtpExpiryTime(LocalDateTime expiresOn) {
        LocalDateTime currentTime = LocalDateTime.now();

        if(currentTime.isAfter(expiresOn)){
            throw new ValidationFailedException(OTP_VAL_EXPIRED_CODE,OTP_VAL_EXPIRED_DESCRIPTION, HttpStatus.BAD_REQUEST);
        }
    }

    private void validateOtpFailedAttempt(Integer optRetires) {
        if(optRetires == null){
            return;
        }
        if(optRetires >= properties.getFailedOtpAttempt()){
            throw new ValidationFailedException(OTP_VAL_FAILED_ATTEMPT_EXCEEDED_CODE,OTP_VAL_FAILED_ATTEMPT_EXCEEDED_DESCRIPTION, HttpStatus.BAD_REQUEST);
        }
    }
}
