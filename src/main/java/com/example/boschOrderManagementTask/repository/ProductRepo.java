package com.example.boschOrderManagementTask.repository;

import com.example.boschOrderManagementTask.Collection.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<Product,String> {
    List<Product> findBySellerId(String sellerId);
}
