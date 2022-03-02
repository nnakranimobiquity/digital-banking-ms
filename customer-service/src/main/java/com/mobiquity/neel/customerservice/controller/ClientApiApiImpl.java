package com.mobiquity.neel.customerservice.controller;

import com.mobiquity.neel.customerservice.service.delegate.ClientApiApiDelegateImpl;
import openapi.api.ClientApiApi;
import openapi.model.CreateCustomerRequestDto;
import openapi.model.CreateCustomerResponseDto;
import openapi.model.GetCustomerResponseDto;
import openapi.model.PatchCustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${openapi.customerAPISpecification.base-path:/customer-service}")
public class ClientApiApiImpl implements ClientApiApi {

    private ClientApiApiDelegateImpl delegate;

    @Autowired
    public ClientApiApiImpl(ClientApiApiDelegateImpl delegate) {
        this.delegate = delegate;
    }

    @Override
    public ClientApiApiDelegateImpl getDelegate() {
        return delegate;
    }


    @Override
    public ResponseEntity<GetCustomerResponseDto> getCustomers(String id, String userName) {
        return getDelegate().getCustomers(id, userName);
    }

    @Override
    public ResponseEntity<Void> deleteCustomerByUserName(String username) {
        return getDelegate().deleteCustomerByUserName(username);
    }

    @Override
    public ResponseEntity<CreateCustomerResponseDto> postCustomers(CreateCustomerRequestDto createCustomerRequestDto) {
        return getDelegate().postCustomers(createCustomerRequestDto);
    }

    @Override
    public ResponseEntity<Void> patchCustomerByUserName(String username, PatchCustomerRequestDto patchCustomerRequestDto) {
        return getDelegate().patchCustomerByUserName(username, patchCustomerRequestDto);
    }
}