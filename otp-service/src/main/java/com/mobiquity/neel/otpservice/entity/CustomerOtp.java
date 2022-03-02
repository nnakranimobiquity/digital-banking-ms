package com.mobiquity.neel.otpservice.entity;

import com.mobiquity.neel.otpservice.entity.embeddable.CustomerOtpId;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "with")
public class CustomerOtp {

    @EmbeddedId
    private CustomerOtpId customerOtpId = new CustomerOtpId();

    private String text;

    @OneToOne
    @MapsId("customerId")
    private Customer customer;

    @Column(length = 160)
    private String otpMessage;

    @Column(length = 6)
    private String otp;

    @Column(scale = 1)
    private Integer optRetires;

    private LocalDateTime expiresOn;

    @CreationTimestamp
    private LocalDateTime createdOn;

}
