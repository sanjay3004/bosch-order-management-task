package com.example.bosch_order_management_task.controller;

import com.example.bosch_order_management_task.Collection.Order;
import com.example.bosch_order_management_task.api.OrderApi;
import com.example.bosch_order_management_task.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController implements OrderApi {
    @Autowired
    OrderServiceImpl orderService;

    public ResponseEntity<?> addUser(Order order) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.addOrder(order));
    }

    public List<Order> get() {
        return orderService.getOrders();
    }

}
