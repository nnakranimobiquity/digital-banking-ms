package com.mobiquity.neel.otpservice.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "security_questions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "with")
public class SecurityQuestion {

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 50)
    private String securityQuestionText;

    @OneToMany(mappedBy = "securityQuestion")
    private final List<CustomerSecurityQuestion> customerSecurityQuestion = new ArrayList<>();

    public void addCustomerSecurityQuestions(CustomerSecurityQuestion customerSecurityQuestion) {
        this.customerSecurityQuestion.add(customerSecurityQuestion);
    }

    public void removeCustomerSecurityQuestions(CustomerSecurityQuestion customerSecurityQuestion) {
        this.customerSecurityQuestion.remove(customerSecurityQuestion);
    }

    @Override
    public String toString() {
        return "SecurityQuestion{" +
                "id=" + id +
                ", securityQuestionText='" + securityQuestionText + '\'' +
                '}';
    }
}
