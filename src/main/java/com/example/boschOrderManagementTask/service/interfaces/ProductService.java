package com.example.boschOrderManagementTask.service.interfaces;

import com.example.boschOrderManagementTask.Collection.Product;

import java.util.List;

public interface ProductService {
     Product addProduct(Product product);
     String setStock(String prodId,int count);
     List<Product> getProduct();
     List<Product> myProduct();
}
