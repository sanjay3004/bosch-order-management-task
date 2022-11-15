package com.example.boschOrderManagementTask.repository;

import com.example.boschOrderManagementTask.Collection.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends MongoRepository<Order,String> {
}
