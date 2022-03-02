package com.mobiquity.neel.otpservice.controller;

import com.mobiquity.neel.otpservice.service.delegate.ServiceApiApiDelegateImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import openapi.api.ServiceApiApi;
import openapi.model.ValidateOtpRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("${openapi.customerAPISpecification.base-path:/otp-service}")
public class ServiceApiApiImpl implements ServiceApiApi {


    private ServiceApiApiDelegateImpl delegate;

    public ServiceApiApiImpl(ServiceApiApiDelegateImpl delegate) {
        this.delegate = delegate;
    }

    @Override
    public ServiceApiApiDelegateImpl getDelegate() {
        return delegate;
    }


    /**
     * POST /service-api/v2/otp/validate
     * service to validate an OTP for Customer
     *
     * @param validateOtpRequestDto (required)
     * @return Success (status code 200)
     * or  (status code 400)
     * or  (status code 404)
     * or  (status code 500)
     */
    @Override
    @ApiOperation(value = "", nickname = "validateOtp", notes = "service to validate an OTP for Customer", tags={ "OTP", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = ""),
            @ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "") })
    @PostMapping(
            value = "/service-api/v2/otp/validate",
            consumes = { "application/json" }
    )
    public ResponseEntity<Void> validateOtp(ValidateOtpRequestDto validateOtpRequestDto) {
        return getDelegate().validateOtp(validateOtpRequestDto);
    }
}
