package org.example.controller;

import org.example.RequestAndResponse.OrderItemRequest;
import org.example.entity.OrderItemEntity;
import org.example.service.IServices.IOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderItem")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderItemController {

    @Autowired
    IOrderItem orderItem;

    @PostMapping(value = "/save")
    public OrderItemEntity saveOrderItem(@RequestBody OrderItemRequest request){
        return orderItem.saveOrderItem(request);
    }

    @GetMapping(value = "/getOrderItem")
    public OrderItemEntity getOrderItem(@RequestParam("id") int orderItemId){
        OrderItemEntity order = orderItem.getOrderItem(orderItemId);
        return order;
    }

    @GetMapping(value = "/getAllOrderItem")
    public OrderItemEntity getAllOrderItem(){
        List<OrderItemEntity> list = orderItem.getAllOrderItem();

        return (OrderItemEntity) list;
    }
}
