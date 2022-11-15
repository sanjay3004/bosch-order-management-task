package com.example.boschOrderManagementTask.api;

import com.example.boschOrderManagementTask.Collection.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductApi {

    @GetMapping("/get")
    public List<Product> getProduct();

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product);

    @PostMapping("/addStock/{prodId}/{count}")
    public ResponseEntity<String> addStock(@PathVariable String prodId, @PathVariable int count);

    @GetMapping("/myProduct")
    public ResponseEntity<List<Product>> myproduct();
}
