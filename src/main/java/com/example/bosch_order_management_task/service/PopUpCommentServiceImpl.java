package com.example.bosch_order_management_task.service;

import com.example.bosch_order_management_task.Collection.Order;
import com.example.bosch_order_management_task.Collection.PopUpComment;
import com.example.bosch_order_management_task.enums.Status;
import com.example.bosch_order_management_task.dto.PopUpCommentDto;
import com.example.bosch_order_management_task.repository.OrderRepo;
import com.example.bosch_order_management_task.repository.PopUpCommentRepo;
import com.example.bosch_order_management_task.service.interfaces.PopUpCommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PopUpCommentServiceImpl implements PopUpCommentService {


    ModelMapper modelMapper=new ModelMapper();

    @Autowired
    PopUpCommentRepo popUpCommentRepo;

    @Autowired
    OrderRepo orderRepo;
    public List<PopUpCommentDto> getComments(String orderId){


        return  popUpCommentRepo.findByOrderId(orderId).stream().map(e->mapper(e)).collect(Collectors.toList());
    }

    public void addComments(String orderId,String comment){
        PopUpComment popUpComment=new PopUpComment(comment,orderId);
        Optional<Order> byId = orderRepo.findById(orderId);
        Status[] values = Status.values();
        popUpComment.setStatus(values[byId.get().getCurrStatus()-1]);
        popUpCommentRepo.save(popUpComment);
    }

    public PopUpCommentDto mapper(PopUpComment comment){

        return new PopUpCommentDto(comment.getStatus(),comment.getComment(),comment.getDateAndTime());

    }
}
