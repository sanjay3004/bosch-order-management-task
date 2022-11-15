package com.example.bosch_order_management_task.service;

import com.example.bosch_order_management_task.Collection.Order;
import com.example.bosch_order_management_task.Collection.OrderStatus;
import com.example.bosch_order_management_task.enums.Status;
import com.example.bosch_order_management_task.dto.OrderStatusDto;
import com.example.bosch_order_management_task.repository.OrderRepo;
import com.example.bosch_order_management_task.repository.OrderStatusRepo;
import com.example.bosch_order_management_task.service.interfaces.StatusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class StatusServiceImpl implements StatusService {

    ModelMapper modelMapper=new ModelMapper();

    @Autowired
    OrderStatusRepo orderStatusRepo;

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    PopUpCommentServiceImpl popUpCommentService;

    Status status;

    public List<OrderStatusDto> getstatus(String orderId){
        return orderStatusRepo.findByOrderId(orderId).stream().map(e->mapper(e)).collect(Collectors.toList());
    }

    public String addStatus(String orderId){

        Optional<Order> order=orderRepo.findById(orderId);
        if(order.isPresent()) {
            if(order.get().getCurrStatus()==6){
               // popUpCommentService.addComments(orderId,comment);
                return "product is already delivered";
            }
            Status[] values = Status.values();
            int currStatus=order.get().getCurrStatus();
            OrderStatus status = new OrderStatus(values[currStatus],orderId);
            order.get().setCurrStatus(currStatus+1);
            orderRepo.save(order.get());
            orderStatusRepo.save(status);
            return "status updated";
        }

        return "order not found";
    }

    public OrderStatusDto mapper(OrderStatus status){
        return modelMapper.map(status,OrderStatusDto.class);
    }

}
