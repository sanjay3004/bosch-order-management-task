package com.example.boschOrderManagementTask.service.interfaces;

import com.example.boschOrderManagementTask.Collection.PopUpComment;
import com.example.boschOrderManagementTask.dto.PopUpCommentDto;

import java.util.List;

public interface PopUpCommentService {
     List<PopUpCommentDto> getComments(String orderId);
     void addComments(String orderId,String comment);

     PopUpCommentDto mapper(PopUpComment comment);
}
