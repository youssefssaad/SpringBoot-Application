package com.group7.airplanesystembackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group7.airplanesystembackend.entity.Customer;
import com.group7.airplanesystembackend.repository.CustomerRepository;
import com.group7.airplanesystembackend.entity.CustomerStatus;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    public List<Customer> getCustomerDetails() {
        return customerRepository.findAllByEmailIsNotNull();
    }

    public String getCustomerEmailById(Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findByCustomerId(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return customer.getEmail();
        } else {
            // Handle the case where the customer with the provided ID is not found
            return null;
        }
    }

    public Customer createOrUpdateCustomer(Customer customer) {

        if (customer.getCustomerStatus() == CustomerStatus.MEMBER) {
        } else {
            customer.setCardNumber(null);
            customer.setCvv(null);
            customer.setBillingAddress(null);
            customer.setCardExpiration(null);
        }
        return customerRepository.save(customer);
    }

    // Delete method
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }

    public List<Customer> getCustomers() {
        return null;
    }

    public Customer getCustomerId(Long id) {
        return null;
    }

    public Customer createCustomer(Customer customer) {
        return null;
    }

    public Customer updateCustomer(Customer customer) {
        return null;
    }

    public boolean deleteCustomer(int id) {
        return false;
    }

}
