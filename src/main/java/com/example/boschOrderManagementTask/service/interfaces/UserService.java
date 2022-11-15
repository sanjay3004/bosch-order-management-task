package com.example.boschOrderManagementTask.service.interfaces;

import com.example.boschOrderManagementTask.Collection.User;
import com.example.boschOrderManagementTask.dto.UserDto;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<UserDto> getUser();
    public UserDto mapper(User user);
}
