package com.example.bosch_order_management_task.service.interfaces;

import com.example.bosch_order_management_task.Collection.User;
import com.example.bosch_order_management_task.dto.UserDto;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<UserDto> getUser();
    public UserDto mapper(User user);
}
