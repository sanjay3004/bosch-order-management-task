package com.example.bosch_order_management_task.controller;

import com.example.bosch_order_management_task.Collection.Product;
import com.example.bosch_order_management_task.api.ProductApi;
import com.example.bosch_order_management_task.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController implements ProductApi {

    @Autowired
    ProductServiceImpl productService;

    public List<Product> getProduct() {
        return productService.getProduct();
    }

    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

    public ResponseEntity<String> addStock(String prodId, int count) {

        return ResponseEntity.status(HttpStatus.OK).body(productService.setStock(prodId, count));
    }

    @Override
    public ResponseEntity<List<Product>> myproduct() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.myProduct());
    }

}
