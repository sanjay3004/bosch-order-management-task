package com.example.boschOrderManagementTask.service.interfaces;

import com.example.boschOrderManagementTask.Collection.OrderStatus;
import com.example.boschOrderManagementTask.dto.OrderStatusDto;

import java.util.List;

public interface StatusService {
     List<OrderStatusDto> getstatus(String orderId);
     String addStatus(String orderId);
    public OrderStatusDto mapper(OrderStatus status);
}
