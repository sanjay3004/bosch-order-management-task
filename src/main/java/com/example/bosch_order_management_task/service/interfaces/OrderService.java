package com.example.bosch_order_management_task.service.interfaces;

import com.example.bosch_order_management_task.Collection.Order;

import java.util.List;

public interface OrderService {
     Object addOrder(Order order);
     List<Order> getOrders();
}
