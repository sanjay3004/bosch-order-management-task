package com.example.bosch_order_management_task.api;

import com.example.bosch_order_management_task.Collection.User;
import com.example.bosch_order_management_task.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserApi {

    @PostMapping("/add")
    public User addUser(@RequestBody User user);

    @GetMapping("/get")
    public List<UserDto> getUser();
}
