package org.example.service.Impl;

import org.example.RequestAndResponse.OrderItemRequest;
import org.example.RequestAndResponse.OrderRequest;
import org.example.entity.AddressEntity;
import org.example.entity.CustomerEntity;
import org.example.entity.OrderEntity;
import org.example.entity.OrderItemEntity;
import org.example.repo.AddressRepository;
import org.example.repo.CustomerRepository;
import org.example.repo.OrderRepository;
import org.example.service.IServices.EmailService;
import org.example.service.IServices.IOrder;
import org.example.service.IServices.IOrderItem;
import org.example.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrder {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    private EmailService emailService;

    @Override
    public OrderEntity saveOrder(OrderRequest request) {
        System.out.println("customer id " + request.getCustomerId() );
        CustomerEntity customer = customerRepository.findById(request.getCustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));
        AddressEntity shipping = addressRepository.findById(request.getShippingAddressId()).orElseThrow(() -> new RuntimeException("Address not found"));
        AddressEntity billing = addressRepository.findById(request.getBillingAddressId()).orElseThrow(()-> new RuntimeException("Billing address not found"));

        OrderEntity order = OrderEntity.builder().orderDate(currentTimeStamp()).customer(customer).billingAddress(billing).shippingAddress(shipping)
                .status(request.getStatus()).totalAmount(new BigDecimal(request.getTotalAmount())).build();

        String emailText = "Dear " + order.getCustomerName() + ",\n\n" +
                "Thank you for your order of " + order.getProduct() + ".\n" +
                "Your order amount is $" + order.getAmount() + ".\n\n" +
                "Best regards,\nYour Company";
        emailService.sendOrderConfirmationEmail(order.getCustomerEmail(), "Order Confirmation", emailText);
       
        
         orderRepository.save(order);
        return order;
    }

    @Override
    public OrderEntity getOrder(Integer id) {

         OrderEntity entity = orderRepository.getById(id);
         return entity;
    }

    @Override
    public List<OrderEntity> getAllOrders() {

        List<OrderEntity> list = orderRepository.findAll();
        return list;
    }

    public static Timestamp currentTimeStamp() {
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Current Timestamp: " + currentTimestamp.getTime() + " milliseconds");
        System.out.println("Formatted Timestamp: " + currentTimestamp.toString());
        return currentTimestamp;
    }
}
