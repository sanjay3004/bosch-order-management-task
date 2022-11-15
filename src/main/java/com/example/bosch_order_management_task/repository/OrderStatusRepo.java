package com.example.bosch_order_management_task.repository;

import com.example.bosch_order_management_task.Collection.OrderStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatusRepo extends MongoRepository<OrderStatus,String> {
    List<OrderStatus> findByOrderId(String orderId);
}
