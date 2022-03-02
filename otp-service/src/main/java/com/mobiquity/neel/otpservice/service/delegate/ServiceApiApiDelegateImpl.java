package com.mobiquity.neel.otpservice.service.delegate;

import com.mobiquity.neel.otpservice.service.CustomerOtpService;
import openapi.api.ServiceApiApiDelegate;
import openapi.model.ValidateOtpRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServiceApiApiDelegateImpl implements ServiceApiApiDelegate {

    private CustomerOtpService customerOtpService;

    public ServiceApiApiDelegateImpl(CustomerOtpService customerOtpService) {
        this.customerOtpService = customerOtpService;
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
     * @see ServiceApiApiImpl#validateOtp
     */
    @Override
    public ResponseEntity<Void> validateOtp(ValidateOtpRequestDto validateOtpRequestDto) {
        return customerOtpService.validateOtp(validateOtpRequestDto);
    }
}
