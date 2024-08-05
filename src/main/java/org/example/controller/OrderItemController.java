package org.example.controller;

import org.example.RequestAndResponse.OrderItemRequest;
import org.example.entity.OrderItemEntity;
import org.example.service.IServices.IOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderItem")
public class OrderItemController {

    @Autowired
    IOrderItem orderItem;

    @PostMapping(value = "/save")
    public OrderItemEntity saveOrderItem(@RequestBody OrderItemRequest request){
        return orderItem.saveOrderItem(request);
    }

    @GetMapping(value = "/getOrderItem")
    public OrderItemEntity getOrderItem(@RequestBody OrderItemRequest request){
        OrderItemEntity order = orderItem.getOrderItem(request.getId());
        return order;
    }

    @GetMapping(value = "/getAllOrderItem")
    public OrderItemEntity getAllOrderItem(){
        List<OrderItemEntity> list = orderItem.getAllOrderItem();

        return (OrderItemEntity) list;
    }
}
