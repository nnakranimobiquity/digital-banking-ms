package com.mobiquity.neel.customerservice.entity;

import com.mobiquity.neel.customerservice.entity.embeddable.CustomerSecurityQuestionId;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer_security_questions")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder(setterPrefix = "with")
public class CustomerSecurityQuestion {

    @EmbeddedId
    private CustomerSecurityQuestionId customerSecurityQuestionId = new CustomerSecurityQuestionId();

    @Column(length = 50)
    private String securityQuestionAnswer;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @ManyToOne
    @MapsId("customerId")
    private Customer customer;

    @ManyToOne
    @MapsId("securityQuestionId")
    private SecurityQuestion securityQuestion;
}
