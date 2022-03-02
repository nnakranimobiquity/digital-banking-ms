package com.mobiquity.neel.customerservice.entity;

import com.mobiquity.neel.customerservice.entity.enumerator.Language;
import com.mobiquity.neel.customerservice.entity.enumerator.UserStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "using")
@With
@EqualsAndHashCode
@ToString
public class Customer {

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 30,unique = true)
    private String  userName;


    @Column(length = 50)
    private String  firstName;


    @Column(length = 50)
    private String  lastName;

    @Column(length = 10)
    private String phoneNumber;

    @Column(length = 50)
    private String email;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private UserStatus status;
//
    @Column(length = 3)
    private String age;

    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    private Language preferredLanguage;

    @Column(length = 50)
    private String externalId;

    @Column(length = 50)
    private String createdBy;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @Column(length = 50)
    private String updatedBy;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private final List<CustomerSecurityQuestion> customerSecurityQuestions = new ArrayList<>();

    @OneToOne(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private  CustomerSecurityImage customerSecurityImages;

    @OneToOne(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private CustomerOtp customerOtp;

    public void addCustomerSecurityQuestions(CustomerSecurityQuestion customerSecurityQuestion) {
        this.customerSecurityQuestions.add(customerSecurityQuestion);
    }

    public void removeCustomerSecurityQuestions(CustomerSecurityQuestion customerSecurityQuestion) {
        this.customerSecurityQuestions.remove(customerSecurityQuestion);
    }

}
