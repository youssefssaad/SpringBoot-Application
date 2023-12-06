package com.group7.airplanesystembackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

import com.group7.airplanesystembackend.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByEmailIsNotNull();
    Optional<Customer> findByCustomerId(Long customerId);
    Optional<Customer> findByEmail(String email);

}
