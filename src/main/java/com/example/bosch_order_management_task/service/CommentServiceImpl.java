package com.example.bosch_order_management_task.service;

import com.example.bosch_order_management_task.Collection.OrderComments;
import com.example.bosch_order_management_task.dto.OrderCommentDto;
import com.example.bosch_order_management_task.repository.OrderCommentsRepo;
import com.example.bosch_order_management_task.service.interfaces.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {


    ModelMapper modelMapper=new ModelMapper();

    @Autowired
    OrderCommentsRepo orderCommentsRepo;

    public List<OrderCommentDto> getComments(String orderId){


        return orderCommentsRepo.findByOrderId(orderId).stream().map(e->mapper(e)).collect(Collectors.toList());

    }

    public void addComments(String orderId,String comment){
        OrderComments orderComments=new OrderComments(comment,orderId);
        orderCommentsRepo.save(orderComments);
    }

    public OrderCommentDto mapper(OrderComments comment){

        return modelMapper.map(comment,OrderCommentDto.class);

    }
}
