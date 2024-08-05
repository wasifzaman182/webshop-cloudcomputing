package org.example.service.Impl;

import org.example.RequestAndResponse.OrderItemRequest;
import org.example.RequestAndResponse.OrderRequest;
import org.example.entity.AddressEntity;
import org.example.entity.CustomerEntity;
import org.example.entity.OrderEntity;
import org.example.entity.OrderItemEntity;
import org.example.repo.OrderRepository;
import org.example.service.IServices.IOrder;
import org.example.service.IServices.IOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrder {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderEntity saveOrder(OrderRequest request) {
        CustomerEntity customer= CustomerEntity.builder().customerId(request.getCustomerId()).build();
        AddressEntity shipping = AddressEntity.builder().addressId(request.getShippingAddressId()).build();
        AddressEntity billing = AddressEntity.builder().addressId(request.getBillingAddressId()).build();

        OrderEntity order = OrderEntity.builder().orderDate(request.getOrderDate()).customer(customer).billingAddress(billing).shippingAddress(shipping)
                .status(request.getStatus()).totalAmount(BigDecimal.valueOf(Long.valueOf(request.getTotalAmount()))).build();
        return orderRepository.save(order);
    }

    @Override
    public OrderEntity getOrder(Integer id) {

        return orderRepository.getById(id);
    }

    @Override
    public List<OrderEntity> getAllOrders() {

        List<OrderEntity> list = orderRepository.findAll();
        return list;
    }
}
