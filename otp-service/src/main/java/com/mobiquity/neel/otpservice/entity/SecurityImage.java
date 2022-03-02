package com.mobiquity.neel.otpservice.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "security_images")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "with")
public class SecurityImage {

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 50)
    private String securityImageName;

    @Column()
    private String securityImageUrl;

    @OneToMany(mappedBy = "securityImage")
    private final List<CustomerSecurityImage> customerSecurityImage = new ArrayList<>();

    public void addCustomerSecurityImage(CustomerSecurityImage customerSecurityImage){
        this.customerSecurityImage.add(customerSecurityImage);
    }

    public void removeCustomerSecurityImage(CustomerSecurityImage customerSecurityImage){
        this.customerSecurityImage.remove(customerSecurityImage);
    }
}
