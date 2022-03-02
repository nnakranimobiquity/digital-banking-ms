package com.mobiquity.neel.otpservice.controller;

import openapi.api.ClientApiApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${openapi.customerAPISpecification.base-path:/otp-service}")
public class ClientApiApiImpl implements ClientApiApi {

//
//    /**
//     * GET /client-api/v1/customers/{username}/securityQuestions : get Security Questions for Customer
//     * Get Security Questions for Customer
//     *
//     * @param username User Name of User (required)
//     * @return Success (status code 200)
//     * or  (status code 400)
//     * or  (status code 500)
//     * or  (status code 404)
//     */
//    @Override
//    public ResponseEntity<GetCustomerSecurityQuestionResponseDto> getSecurityQuestionsByUserName(String username) {
//        return getDelegate().getSecurityQuestionsByUserName(username);
//    }
}