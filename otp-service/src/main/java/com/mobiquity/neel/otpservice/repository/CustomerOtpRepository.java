package com.mobiquity.neel.otpservice.repository;

import com.mobiquity.neel.otpservice.entity.CustomerOtp;
import com.mobiquity.neel.otpservice.entity.embeddable.CustomerOtpId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomerOtpRepository extends JpaRepository<CustomerOtp, CustomerOtpId> {
}
