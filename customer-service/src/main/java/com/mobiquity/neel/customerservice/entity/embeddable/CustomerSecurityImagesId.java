package com.mobiquity.neel.customerservice.entity.embeddable;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSecurityImagesId implements Serializable {

    @Column(length = 36)
    private String customerId;

    @Column(length = 36)
    private String securityImageId;


}
