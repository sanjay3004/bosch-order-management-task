package com.example.bosch_order_management_task.controller;

import com.example.bosch_order_management_task.Collection.User;
import com.example.bosch_order_management_task.api.UserApi;
import com.example.bosch_order_management_task.dto.UserDto;
import com.example.bosch_order_management_task.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements UserApi {

    @Autowired
    UserServiceImpl userService;

    public User addUser(User user) {
        return userService.addUser(user);

    }

    public List<UserDto> getUser() {
        return userService.getUser();
    }
}
