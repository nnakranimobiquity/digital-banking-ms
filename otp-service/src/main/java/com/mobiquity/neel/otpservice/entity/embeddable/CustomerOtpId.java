package com.mobiquity.neel.otpservice.entity.embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class CustomerOtpId implements Serializable {

    @Column(length = 36,name = "customer_id")
    private String customerId;

    private String otpId;

    public CustomerOtpId() {
        otpId = UUID.randomUUID().toString();
    }
}
