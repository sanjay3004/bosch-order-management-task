package com.example.boschOrderManagementTask.service.interfaces;

import com.example.boschOrderManagementTask.Collection.Order;

import java.util.List;

public interface OrderService {
     Object addOrder(Order order);
     List<Order> getOrders();
}
