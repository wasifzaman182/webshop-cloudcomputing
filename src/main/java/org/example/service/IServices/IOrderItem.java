package org.example.service.IServices;

import org.example.RequestAndResponse.OrderItemRequest;
import org.example.entity.OrderItemEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderItem {

    OrderItemEntity saveOrderItem(OrderItemRequest request);
    OrderItemEntity getOrderItem(Integer id);

    List<OrderItemEntity> getAllOrderItem();
}
