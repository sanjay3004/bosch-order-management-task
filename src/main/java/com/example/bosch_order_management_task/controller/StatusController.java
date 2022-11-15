package com.example.bosch_order_management_task.controller;

import com.example.bosch_order_management_task.api.StatusApi;
import com.example.bosch_order_management_task.dto.OrderStatusDto;
import com.example.bosch_order_management_task.repository.OrderStatusRepo;
import com.example.bosch_order_management_task.service.PopUpCommentServiceImpl;
import com.example.bosch_order_management_task.service.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatusController implements StatusApi {

    @Autowired
    OrderStatusRepo orderStatusRepo;

    @Autowired
    StatusServiceImpl statusService;

    @Autowired
    PopUpCommentServiceImpl popUpCommentService;

    @Override
    public ResponseEntity<List<OrderStatusDto>> getStatus(String orderId) {
        List<OrderStatusDto> statuses = statusService.getstatus(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(statuses);
    }

    @Override
    public ResponseEntity<String> addStatus(String orderId, String comment) {
        String add = statusService.addStatus(orderId);
        popUpCommentService.addComments(orderId, comment);
        return ResponseEntity.status(HttpStatus.OK).body(add);
    }
}
