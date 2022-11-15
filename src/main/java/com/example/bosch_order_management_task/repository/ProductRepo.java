package com.example.bosch_order_management_task.repository;

import com.example.bosch_order_management_task.Collection.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends MongoRepository<Product,String> {
    List<Product> findBySellerId(String sellerId);
}
