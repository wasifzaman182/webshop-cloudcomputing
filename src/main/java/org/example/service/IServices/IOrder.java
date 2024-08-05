package org.example.service.IServices;

import org.example.RequestAndResponse.OrderRequest;
import org.example.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrder {

    OrderEntity saveOrder(OrderRequest request);
    OrderEntity getOrder(Integer id);
    List<OrderEntity> getAllOrders();
}
