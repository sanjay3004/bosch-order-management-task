package com.example.boschOrderManagementTask.service.interfaces;

import com.example.boschOrderManagementTask.Collection.Order;
import com.example.boschOrderManagementTask.Collection.OrderComments;
import com.example.boschOrderManagementTask.dto.OrderCommentDto;

import java.util.List;

public interface CommentService {

     void addComments(String orderId,String comment);

     List<OrderCommentDto> getComments(String orderId);

     OrderCommentDto mapper(OrderComments comment);

}
