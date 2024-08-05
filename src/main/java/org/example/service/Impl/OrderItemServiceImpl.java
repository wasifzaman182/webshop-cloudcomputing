package org.example.service.Impl;

import org.example.RequestAndResponse.OrderItemRequest;
import org.example.entity.OrderEntity;
import org.example.entity.OrderItemEntity;
import org.example.entity.ProductManagementEntity;
import org.example.repo.OrderItemRepository;
import org.example.service.IServices.IOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderItemServiceImpl implements IOrderItem {

    @Autowired
    OrderItemRepository itemRepository;

    @Override
    public OrderItemEntity saveOrderItem(OrderItemRequest request) {
        OrderEntity order = OrderEntity.builder().orderId(request.getOrderId()).build();
        ProductManagementEntity management = ProductManagementEntity.builder().productId(request.getProductId()).build();

        OrderItemEntity orderItem = OrderItemEntity.builder().order(order).product(management).quantity(request.getQuantity()).price(BigDecimal.valueOf(Long.parseLong(request.getPrice()))).build();

        return itemRepository.save(orderItem);

    }

    @Override
    public OrderItemEntity getOrderItem(Integer id) {

        return itemRepository.getById(id);
    }

    @Override
    public List<OrderItemEntity> getAllOrderItem() {
       List<OrderItemEntity> orderItemEntityList = itemRepository.findAll();
        return orderItemEntityList;
    }
}
