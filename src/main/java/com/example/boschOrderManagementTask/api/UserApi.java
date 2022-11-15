package com.example.boschOrderManagementTask.api;

import com.example.boschOrderManagementTask.Collection.User;
import com.example.boschOrderManagementTask.dto.UserDto;
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
