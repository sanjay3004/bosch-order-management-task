package com.example.boschOrderManagementTask.service;

import com.example.boschOrderManagementTask.Collection.Order;
import com.example.boschOrderManagementTask.Collection.PopUpComment;
import com.example.boschOrderManagementTask.Collection.enums.Status;
import com.example.boschOrderManagementTask.dto.PopUpCommentDto;
import com.example.boschOrderManagementTask.repository.OrderRepo;
import com.example.boschOrderManagementTask.repository.PopUpCommentRepo;
import com.example.boschOrderManagementTask.service.interfaces.PopUpCommentService;
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
