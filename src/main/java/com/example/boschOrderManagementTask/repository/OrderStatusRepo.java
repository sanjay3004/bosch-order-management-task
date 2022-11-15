package com.example.boschOrderManagementTask.repository;

import com.example.boschOrderManagementTask.Collection.OrderStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatusRepo extends MongoRepository<OrderStatus,String> {
    List<OrderStatus> findByOrderId(String orderId);
}
