package com.example.boschOrderManagementTask.repository;

import com.example.boschOrderManagementTask.Collection.OrderComments;
import com.example.boschOrderManagementTask.Collection.PopUpComment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PopUpCommentRepo extends MongoRepository<PopUpComment,String> {
    List<PopUpComment> findByOrderId(String orderId);
}
