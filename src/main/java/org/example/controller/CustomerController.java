package org.example.controller;

import com.stripe.model.Customer;
import org.example.RequestAndResponse.CustomerRequest;
import org.example.entity.CustomerEntity;
import org.example.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/saveCustomer")
    public CustomerEntity createCustomer(@RequestBody CustomerRequest customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/getCustomer")
    public Optional<CustomerEntity> getCustomerById(@RequestBody CustomerRequest request) {
        Integer id = request.getCustomerId();
        return customerService.getCustomerById(id);
    }

    @GetMapping("/getAllCustomer")
    public List<CustomerEntity> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/updateCustomer")
    public CustomerEntity updateCustomer(@RequestBody CustomerEntity updatedCustomer) {
        return customerService.updateCustomer(updatedCustomer);
    }

    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestBody CustomerRequest request) {
        Integer customerId = request.getCustomerId();
        customerService.deleteCustomer(customerId);
    }
}
