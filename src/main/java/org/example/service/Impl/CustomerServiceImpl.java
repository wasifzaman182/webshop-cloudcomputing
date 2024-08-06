package org.example.service.Impl;

import org.example.RequestAndResponse.CustomerRequest;
import org.example.entity.AddressEntity;
import org.example.entity.CustomerEntity;
import org.example.repo.AddressRepository;
import org.example.repo.CustomerRepository;
import org.example.service.IServices.ICustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements ICustomer {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public CustomerEntity createCustomer(CustomerRequest customer) {
        CustomerEntity customerEntity = CustomerEntity.builder().email(customer.getEmail()).firstName(customer.getFirstName())
                .lastName(customer.getLastName()).phoneNumber(customer.getPhoneNumber()).build();

        customerRepository.save(customerEntity);

        AddressEntity addressEntity = AddressEntity.builder().state(customer.getState()).city(customer.getCity()).zipCode(customer.getZipCode())
                .country(customer.getCountry()).street(customer.getStreet()).customer(customerEntity).build();

        addressRepository.save(addressEntity);

        return customerEntity;
    }

    @Override
    public Optional<CustomerEntity> getCustomerById(Integer customerId) {
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
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
