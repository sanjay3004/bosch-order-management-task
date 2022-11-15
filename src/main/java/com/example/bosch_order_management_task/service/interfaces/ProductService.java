package com.example.bosch_order_management_task.service.interfaces;

import com.example.bosch_order_management_task.Collection.Product;

import java.util.List;

public interface ProductService {
     Product addProduct(Product product);
     String setStock(String prodId,int count);
     List<Product> getProduct();
     List<Product> myProduct();
}
