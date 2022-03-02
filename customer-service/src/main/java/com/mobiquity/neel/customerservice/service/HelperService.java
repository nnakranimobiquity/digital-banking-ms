package com.mobiquity.neel.customerservice.service;

import com.mobiquity.neel.customerservice.entity.*;
import com.mobiquity.neel.customerservice.entity.enumerator.Language;
import com.mobiquity.neel.customerservice.entity.enumerator.UserStatus;
import com.mobiquity.neel.customerservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class HelperService {
    @Autowired
    CustomerRepository customerRepository;

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
    }
}
