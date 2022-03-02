package com.mobiquity.neel.otpservice.entity;

import com.mobiquity.neel.otpservice.entity.embeddable.CustomerSecurityImagesId;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_security_images")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "with")
public class CustomerSecurityImage {

    @EmbeddedId
    private final CustomerSecurityImagesId customerSecurityImagesId = new CustomerSecurityImagesId();

    @OneToOne
    @MapsId("customerId")
    private Customer customer;

    @ManyToOne
    @MapsId("securityImageId")
    private SecurityImage securityImage;

    @Column(length = 50)
    private String securityImageCaption;

    @CreationTimestamp
    private LocalDateTime createdOn;
}