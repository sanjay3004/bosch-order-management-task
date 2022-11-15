package com.example.bosch_order_management_task.repository;

import com.example.bosch_order_management_task.Collection.PopUpComment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PopUpCommentRepo extends MongoRepository<PopUpComment,String> {
    List<PopUpComment> findByOrderId(String orderId);
}
