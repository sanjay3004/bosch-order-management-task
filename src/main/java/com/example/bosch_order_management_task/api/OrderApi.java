package com.example.bosch_order_management_task.api;

import com.example.bosch_order_management_task.Collection.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderApi {
    @PostMapping("/add")
    ResponseEntity<?> addUser(@RequestBody Order order);


    @GetMapping("/get")
    List<Order> get();
}
