package com.mobiquity.neel.customerservice.service.delegate;

import com.mobiquity.neel.customerservice.service.CustomerService;
import openapi.api.ClientApiApiDelegate;
import openapi.model.CreateCustomerRequestDto;
import openapi.model.CreateCustomerResponseDto;
import openapi.model.GetCustomerResponseDto;
import openapi.model.PatchCustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ClientApiApiDelegateImpl implements ClientApiApiDelegate {

    private final CustomerService customerService;

    @Autowired
    public ClientApiApiDelegateImpl(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public ResponseEntity<GetCustomerResponseDto> getCustomers(String id, String userName) {
        return customerService.getCustomers(id, userName);
    }

    @Override
    public ResponseEntity<Void> deleteCustomerByUserName(String username) {
        return customerService.deleteCustomerByUserName(username);
    }

    @Override
    public ResponseEntity<CreateCustomerResponseDto> postCustomers(CreateCustomerRequestDto createCustomerRequestDto) {
        return customerService.postCustomers(createCustomerRequestDto);
    }

    @Override
    public ResponseEntity<Void> patchCustomerByUserName(String username, PatchCustomerRequestDto patchCustomerRequestDto) {
        return customerService.patchCustomerByUserName(username, patchCustomerRequestDto);
    }
}
