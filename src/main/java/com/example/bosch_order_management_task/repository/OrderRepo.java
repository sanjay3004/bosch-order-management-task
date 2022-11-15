package com.example.bosch_order_management_task.repository;

import com.example.bosch_order_management_task.Collection.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends MongoRepository<Order,String> {
}
