package com.example.bosch_order_management_task.repository;

import com.example.bosch_order_management_task.Collection.OrderComments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderCommentsRepo extends MongoRepository<OrderComments,String> {
    List<OrderComments> findByOrderId(String orderId);
}
