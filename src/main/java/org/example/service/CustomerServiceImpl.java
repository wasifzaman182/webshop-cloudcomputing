package org.example.service;

import org.example.RequestAndResponse.CustomerRequest;
import org.example.entity.CustomerEntity;
import org.example.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements ICustomer{

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public CustomerEntity createCustomer(CustomerRequest customer) {
        CustomerEntity customerEntity = CustomerEntity.builder().email(customer.getEmail()).firstName(customer.getFirstName())
                .lastName(customer.getLastName()).phoneNumber(customer.getPhoneNumber()).build();

        return customerRepository.save(customerEntity);
    }

    @Override
    public Optional<CustomerEntity> getCustomerById(Long customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity updatedCustomer) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findById(updatedCustomer.getCustomerId());
        if (optionalCustomer.isPresent()) {
            CustomerEntity existingCustomer = optionalCustomer.get();
            existingCustomer.setFirstName(updatedCustomer.getFirstName());
            existingCustomer.setLastName(updatedCustomer.getLastName());
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
            return customerRepository.save(existingCustomer);
        }
        return null;
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
