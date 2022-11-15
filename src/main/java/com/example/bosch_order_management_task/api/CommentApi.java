package com.example.bosch_order_management_task.api;


import com.example.bosch_order_management_task.dto.CommentRequestDto;
import com.example.bosch_order_management_task.dto.OrderCommentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CommentApi {

    @GetMapping("/comment/get/{orderId}")
    public ResponseEntity<List<OrderCommentDto>> getComments(@PathVariable String orderId);

    @PostMapping("/comment/add")
    ResponseEntity<List<OrderCommentDto>> addComments(@RequestBody CommentRequestDto commentRequestDto);
}
