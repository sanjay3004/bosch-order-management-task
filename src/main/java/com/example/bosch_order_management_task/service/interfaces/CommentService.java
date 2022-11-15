package com.example.bosch_order_management_task.service.interfaces;

import com.example.bosch_order_management_task.Collection.OrderComments;
import com.example.bosch_order_management_task.dto.OrderCommentDto;

import java.util.List;

public interface CommentService {

     void addComments(String orderId,String comment);

     List<OrderCommentDto> getComments(String orderId);

     OrderCommentDto mapper(OrderComments comment);

}
