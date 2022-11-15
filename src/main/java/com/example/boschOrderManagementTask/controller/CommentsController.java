package com.example.boschOrderManagementTask.controller;

import com.example.boschOrderManagementTask.api.CommentApi;
import com.example.boschOrderManagementTask.dto.CommentRequestDto;
import com.example.boschOrderManagementTask.dto.OrderCommentDto;
import com.example.boschOrderManagementTask.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CommentsController implements CommentApi {

    @Autowired
    CommentServiceImpl commentService;

    @Override
    public ResponseEntity<List<OrderCommentDto>> getComments(String orderId) {
        List<OrderCommentDto> comments = commentService.getComments(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }

    @Override
    public ResponseEntity<List<OrderCommentDto>> addComments(CommentRequestDto commentRequestDto) {
        commentService.addComments(commentRequestDto.getOrderId(), commentRequestDto.getComment());
        return getComments(commentRequestDto.getOrderId());
    }

}
