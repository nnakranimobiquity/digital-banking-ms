package com.mobiquity.neel.otpservice.entity.embeddable;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class CustomerSecurityQuestionId implements Serializable {

    private String customerId;

    private String securityQuestionId;
}
