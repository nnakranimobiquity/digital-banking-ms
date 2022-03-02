package com.mobiquity.neel.customerservice.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:customer.yml")
@PropertySource("classpath:create-customer.yml")
@Getter
public class Properties {

    @Value("${phoneNumber:[0-9]{10}}")
    private String phoneRegEx;

    @Value("${email:^[A-Za-z][A-Za-z0-9_]{7,29}$}")
    private String emailRegEx;

    @Value("${userName:[\\w+.]*@\\w+.[com|in]{2,3}}")
    private String userNameRegEx;

    @Value("${age-url}")
    private String url;
}
