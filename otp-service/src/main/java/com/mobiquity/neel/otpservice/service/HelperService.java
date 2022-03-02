package com.mobiquity.neel.otpservice.service;

import com.mobiquity.neel.otpservice.entity.Customer;
import com.mobiquity.neel.otpservice.entity.CustomerOtp;
import com.mobiquity.neel.otpservice.entity.embeddable.CustomerOtpId;
import com.mobiquity.neel.otpservice.entity.enumerator.Language;
import com.mobiquity.neel.otpservice.entity.enumerator.UserStatus;
import com.mobiquity.neel.otpservice.repository.CustomerOtpRepository;
import com.mobiquity.neel.otpservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class HelperService {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerOtpRepository customerOtpRepository;


    @Transactional
    public ResponseEntity<Void> populateData() {
        populateData1();
        return ResponseEntity.ok().build();
    }

    public void populateData1() {

        Customer customer =
                Customer.builder()
                        .usingUserName("userName")
                        .usingFirstName("Neel")
                        .usingLastName("Nakrani")
                        .usingStatus(UserStatus.ACTIVE)
                        .usingPreferredLanguage(Language.EN)
                        .usingExternalId("userName_ext")
                        .usingCreatedBy("createdBy")
                        .usingUpdatedBy("updatedBy")
                        .build();

        customerRepository.save(customer);

        CustomerOtp customerOtp = CustomerOtp.builder()
                .withOtp("123456")
                .withCustomer(customer)
                .withCustomerOtpId(new CustomerOtpId())
                .withOptRetires(0)
                .withCreatedOn(LocalDateTime.now())
                .withExpiresOn(LocalDateTime.now().plusMinutes(5))
                .build();

        customerOtpRepository.save(customerOtp);

    }
}
