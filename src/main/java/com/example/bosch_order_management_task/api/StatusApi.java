package com.example.bosch_order_management_task.api;

import com.example.bosch_order_management_task.dto.OrderStatusDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StatusApi {

    @GetMapping("/status/get/{orderId}")
    ResponseEntity<List<OrderStatusDto>> getStatus(@PathVariable String orderId);

    @PostMapping("/status/change/{orderId}")
    ResponseEntity<String> addStatus(@PathVariable String orderId, @RequestBody String comment);


}
