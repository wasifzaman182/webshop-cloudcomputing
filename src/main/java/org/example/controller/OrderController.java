package org.example.controller;

import org.example.RequestAndResponse.OrderRequest;
import org.example.entity.OrderEntity;
import org.example.service.IServices.IOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    IOrder order;

    @PostMapping(value = "/saveOrder")
    public OrderEntity saveOrder(@RequestBody OrderRequest request){
        return order.saveOrder(request);
    }

    @GetMapping(value = "/getOrder")
    public OrderEntity getOrder(@RequestBody OrderRequest request){
        return order.getOrder(request.getId());
    }

    @GetMapping(value = "/getAllOrder")
    public List<OrderEntity> getAllOrder(){
        List<OrderEntity> list = order.getAllOrders();
        return list;
    }
}
