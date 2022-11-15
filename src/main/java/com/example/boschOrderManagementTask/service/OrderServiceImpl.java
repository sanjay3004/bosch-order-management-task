package com.example.boschOrderManagementTask.service;


import com.example.boschOrderManagementTask.Collection.Order;
import com.example.boschOrderManagementTask.Collection.OrderStatus;
import com.example.boschOrderManagementTask.Collection.Product;
import com.example.boschOrderManagementTask.Collection.User;
import com.example.boschOrderManagementTask.Collection.enums.Status;
import com.example.boschOrderManagementTask.repository.OrderRepo;
import com.example.boschOrderManagementTask.repository.OrderStatusRepo;
import com.example.boschOrderManagementTask.repository.ProductRepo;
import com.example.boschOrderManagementTask.service.interfaces.CommentService;
import com.example.boschOrderManagementTask.service.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderStatusRepo orderStatusRepo;

    @Autowired
    ProductRepo productRepo;

    public Object addOrder(Order order){

        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Product> product=productRepo.findById(order.getProductId());
        if(product.get().getAvailable()==0){
            return "there is no stock";
        }
        order.setBuyerId(user.getId());
        order.setDateTime(LocalDateTime.now());
        order.setSellerId(product.get().getSellerId());
        Order placedOrder=orderRepo.save(order);
        product.get().setAvailable(product.get().getAvailable()-1);
        productRepo.save(product.get());
        OrderStatus orderStatus=new OrderStatus(Status.ORDER_PLACED,placedOrder.getId());
        orderStatusRepo.save(orderStatus);
        return placedOrder;

    }

    public List<Order> getOrders(){
        return orderRepo.findAll();
    }

}
