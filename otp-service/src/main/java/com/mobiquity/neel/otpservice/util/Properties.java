package com.mobiquity.neel.otpservice.util;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:otp-validation.yml")
@Getter
public class Properties {
    @Value("${failedOtpAttempt:3}")
    private Integer failedOtpAttempt;
}
