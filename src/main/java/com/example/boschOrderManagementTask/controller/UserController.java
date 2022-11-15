package com.example.boschOrderManagementTask.controller;

import com.example.boschOrderManagementTask.Collection.User;
import com.example.boschOrderManagementTask.api.UserApi;
import com.example.boschOrderManagementTask.dto.UserDto;
import com.example.boschOrderManagementTask.service.UserServiceImpl;
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
