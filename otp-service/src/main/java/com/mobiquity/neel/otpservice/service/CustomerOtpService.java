package com.mobiquity.neel.otpservice.service;

import com.mobiquity.neel.otpservice.entity.Customer;
import com.mobiquity.neel.otpservice.entity.CustomerOtp;
import com.mobiquity.neel.otpservice.exception.ValidationFailedException;
import com.mobiquity.neel.otpservice.repository.CustomerOtpRepository;
import com.mobiquity.neel.otpservice.validator.CustomerOtpValidator;
import openapi.model.ValidateOtpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.mobiquity.neel.otpservice.util.Constants.*;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class CustomerOtpService {

    private final CustomerOtpValidator customerOtpValidator;
    private final CustomerService customerService;
    private final CustomerOtpRepository customerOtpRepository;


    @Autowired
    public CustomerOtpService(CustomerOtpValidator customerOtpValidator, CustomerService customerService, CustomerOtpRepository customerOtpRepository) {
        this.customerOtpValidator = customerOtpValidator;
        this.customerService = customerService;
        this.customerOtpRepository = customerOtpRepository;
    }

    public ResponseEntity<Void> validateOtp(ValidateOtpRequestDto validateOtpRequestDto) {
        validateOtpWithSystemInitiatedOtp(validateOtpRequestDto);
        return ResponseEntity.ok().build();
    }

    private void validateOtpWithSystemInitiatedOtp(ValidateOtpRequestDto validateOtpRequestDto) {
        customerOtpValidator.validateOtpRequestDto(validateOtpRequestDto);
        Customer customer = customerService.findCustomerByUserName(validateOtpRequestDto.getUserName(), OTP_VAL_CUSTOMER_NOT_FOUND_CODE,OTP_VAL_CUSTOMER_NOT_FOUND_DESCRIPTION,BAD_REQUEST);

        if(!customerOtpValidator.validateOtpWithSystemInitiatedOtp(validateOtpRequestDto,customer.getCustomerOtp())){
            increaseOtpRetriesCount(customer.getCustomerOtp());
            throw new ValidationFailedException(OTP_VAL_INCORRECT_CODE,OTP_VAL_INCORRECT_DESCRIPTION, HttpStatus.BAD_REQUEST);
        }
    }

    private void increaseOtpRetriesCount(CustomerOtp customerOtp) {
        Integer incrementedOtpRetires = (Objects.isNull(customerOtp.getOptRetires()))? 1:customerOtp.getOptRetires()+1;
        customerOtp.setOptRetires(incrementedOtpRetires);
        customerOtpRepository.save(customerOtp);
    }
}
