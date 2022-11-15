package com.example.bosch_order_management_task.service.interfaces;

import com.example.bosch_order_management_task.Collection.PopUpComment;
import com.example.bosch_order_management_task.dto.PopUpCommentDto;

import java.util.List;

public interface PopUpCommentService {
     List<PopUpCommentDto> getComments(String orderId);
     void addComments(String orderId,String comment);

     PopUpCommentDto mapper(PopUpComment comment);
}
