package com.example.boschOrderManagementTask.service;

import com.example.boschOrderManagementTask.Collection.Product;
import com.example.boschOrderManagementTask.Collection.User;
import com.example.boschOrderManagementTask.repository.ProductRepo;
import com.example.boschOrderManagementTask.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    public Product addProduct(Product product){
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        product.setSellerId(user.getId());
        product.setDateTime(LocalDateTime.now());
        return productRepo.save(product);
    }

    public String setStock(String prodId,int count){
        Optional<Product> product = productRepo.findById(prodId);
        if(product.isEmpty()){
            return "product not found";
        }
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(product.get().getSellerId().equals(user.getId())) {
            product.get().setAvailable(product.get().getAvailable() + count);
            productRepo.save(product.get());
            return "successfully changed";
        }
        else {
            return "you are not allowed to change another one's product";
        }
    }

    public List<Product> getProduct(){
        return productRepo.findAll();
    }

    public List<Product> myProduct(){
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return productRepo.findBySellerId(user.getId());
    }
}
