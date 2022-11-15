package com.example.bosch_order_management_task.service.interfaces;

import com.example.bosch_order_management_task.Collection.OrderStatus;
import com.example.bosch_order_management_task.dto.OrderStatusDto;

import java.util.List;

public interface StatusService {
     List<OrderStatusDto> getstatus(String orderId);
     String addStatus(String orderId);
    public OrderStatusDto mapper(OrderStatus status);
}
