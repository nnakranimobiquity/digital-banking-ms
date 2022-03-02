package com.mobiquity.neel.otpservice.service;

import com.mobiquity.neel.otpservice.entity.Customer;
import com.mobiquity.neel.otpservice.exception.ValidationFailedException;
import com.mobiquity.neel.otpservice.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerByUserName(String userName, String errorCode, String errorDescription, HttpStatus status) {
        return customerRepository.findByUserName(userName).orElseThrow(() -> new ValidationFailedException(errorCode,errorDescription, status));
    }

    private Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }



}
