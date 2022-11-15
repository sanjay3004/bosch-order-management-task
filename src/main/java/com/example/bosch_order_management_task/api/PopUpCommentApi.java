package com.example.bosch_order_management_task.api;


import com.example.bosch_order_management_task.dto.PopUpCommentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PopUpCommentApi {

    @GetMapping("/get/{orderId}")
    ResponseEntity<List<PopUpCommentDto>> getComments(@PathVariable String orderId);

}
