package org.example.service;

import org.example.RequestAndResponse.CustomerRequest;
import org.example.entity.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICustomer {

    CustomerEntity createCustomer(CustomerRequest customer);
    Optional<CustomerEntity> getCustomerById(Integer customerId);
    List<CustomerEntity> getAllCustomers();
    CustomerEntity updateCustomer(CustomerEntity updatedCustomer);
    void deleteCustomer(Integer customerId);
}
