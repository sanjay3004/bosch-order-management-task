package com.example.boschOrderManagementTask.controller;

import com.example.boschOrderManagementTask.api.PopUpCommentApi;
import com.example.boschOrderManagementTask.dto.PopUpCommentDto;
import com.example.boschOrderManagementTask.service.PopUpCommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/popUpComment")
public class PopUpCommentController implements PopUpCommentApi {

    @Autowired
    PopUpCommentServiceImpl commentService;


    @Override
    public ResponseEntity<List<PopUpCommentDto>> getComments(String orderId) {
        List<PopUpCommentDto> comments = commentService.getComments(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(comments);
    }


}
