package com.mobiquity.neel.customerservice.service;

import com.mobiquity.neel.customerservice.entity.Customer;
import com.mobiquity.neel.customerservice.exception.ValidationFailedException;
import com.mobiquity.neel.customerservice.mapper.CustomerMapperImpl;
import com.mobiquity.neel.customerservice.repository.CustomerRepository;
import com.mobiquity.neel.customerservice.validator.CustomerValidator;
import com.mobiquity.neel.customerservice.validator.annotation.CreateCustomerRequestDtoValidation;
import com.mobiquity.neel.customerservice.validator.annotation.PatchCustomerRequestDtoValidation;
import openapi.model.CreateCustomerRequestDto;
import openapi.model.CreateCustomerResponseDto;
import openapi.model.GetCustomerResponseDto;
import openapi.model.PatchCustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

import static com.mobiquity.neel.customerservice.util.Constants.*;
import static org.springframework.http.HttpStatus.*;

@Service
@Validated
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerValidator customerValidator;
    private final CustomerMapperImpl customerMapperInterface;
    private final CustomerAgeService customerAgeService;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerValidator customerValidator, CustomerMapperImpl customerMapperInterface, CustomerAgeService customerAgeService) {
        this.customerRepository = customerRepository;
        this.customerValidator = customerValidator;
        this.customerMapperInterface = customerMapperInterface;
        this.customerAgeService = customerAgeService;
    }

    public Customer findCustomerByUserName(String userName, String errorCode, String errorDescription, HttpStatus status) {
        return customerRepository.findByUserName(userName).orElseThrow(() -> new ValidationFailedException(errorCode,errorDescription, status));
    }

    private Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    public ResponseEntity<GetCustomerResponseDto> getCustomers(String id, String userName) {
        String result = customerValidator.validateIdAndUserName(id, userName);
        Customer customer = getCustomer(result,id,userName);
        return ResponseEntity.ok(customerMapperInterface.customerToGetCustomerResponseDto(customer));
    }

    private Customer getCustomer(String result,String id, String userName) {
        return switch (result) {
            case "00" -> throw new ValidationFailedException(CUS_MANDATORY_FIELD_NOT_VALID_CODE, CUS_MANDATORY_FIELD_NOT_VALID_DESCRIPTION, BAD_REQUEST);
            case "10" -> Optional.ofNullable(findCustomerById(id)).orElseThrow(() -> new ValidationFailedException(CUS_CUSTOMER_NOT_FOUND_CODE, CUS_CUSTOMER_NOT_FOUND_DESCRIPTION, NOT_FOUND));
            case "01" -> findCustomerByUserName(userName, CUS_CUSTOMER_NOT_FOUND_CODE,CUS_CUSTOMER_NOT_FOUND_DESCRIPTION,NOT_FOUND);
            case "11" -> Optional.ofNullable(findCustomerById(id)).orElseGet(() -> findCustomerByUserName(userName, CUS_CUSTOMER_NOT_FOUND_CODE,CUS_CUSTOMER_NOT_FOUND_DESCRIPTION,NOT_FOUND));
            default -> throw new ValidationFailedException();
        };
    }

    public ResponseEntity<Void> deleteCustomerByUserName(String username) {
        if(Objects.isNull(username) || username.trim().isEmpty())
        {
            throw new ValidationFailedException(CUS_DELETE_CUSTOMER_NOT_FOUND_CODE, CUS_DELETE_CUSTOMER_NOT_FOUND_DESCRIPTION, NOT_FOUND);
        }
        Customer customerByUserName = findCustomerByUserName(username, CUS_DELETE_CUSTOMER_NOT_FOUND_CODE,CUS_DELETE_CUSTOMER_NOT_FOUND_DESCRIPTION, NOT_FOUND);
        customerRepository.delete(customerByUserName);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<CreateCustomerResponseDto> postCustomers(@Valid @CreateCustomerRequestDtoValidation CreateCustomerRequestDto createCustomerRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createCustomerUsingCreateCustomerRequestDto(createCustomerRequestDto));
    }

    private CreateCustomerResponseDto createCustomerUsingCreateCustomerRequestDto(CreateCustomerRequestDto createCustomerRequestDto) {
        isUniqueUserName(createCustomerRequestDto.getUserName());
        Customer customer = customerMapperInterface.createCustomerRequestDtoToCustomer(createCustomerRequestDto, customerAgeService.findAgeForCustomer1(createCustomerRequestDto.getUserName()));
        return new CreateCustomerResponseDto().id(customerRepository.save(customer).getId());
    }

    private void isUniqueUserName(String userName) {
        if(customerRepository.existsByUserName(userName))
        {
            throw new ValidationFailedException(CUS_CREATE_USERNAME_NOT_UNIQUE_CODE,CUS_CREATE_USERNAME_NOT_UNIQUE_DESCRIPTION, BAD_REQUEST);
        }
    }

    public ResponseEntity<Void> patchCustomerByUserName(String username,@Valid @PatchCustomerRequestDtoValidation PatchCustomerRequestDto patchCustomerRequestDto) {
        customerValidator.validateUserName(username);
        Customer customer = findCustomerByUserName(username, CUS_UPDATE_CUSTOMER_NOT_FOUND_CODE, CUS_UPDATE_CUSTOMER_NOT_FOUND_DESCRIPTION, NOT_FOUND);
        customerRepository.save(customerMapperInterface.updateCustomerFromPatchCustomerRequestDto(patchCustomerRequestDto,customer));
        return ResponseEntity.ok().build();
    }
}
