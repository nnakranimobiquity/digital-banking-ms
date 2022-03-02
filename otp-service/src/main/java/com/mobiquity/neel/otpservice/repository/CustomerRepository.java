package com.mobiquity.neel.otpservice.repository;

import com.mobiquity.neel.otpservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByUserName(String userName);

    boolean existsByUserName(String userName);

    List<Customer> findByIdOrUserName(String userName, String id);
}
