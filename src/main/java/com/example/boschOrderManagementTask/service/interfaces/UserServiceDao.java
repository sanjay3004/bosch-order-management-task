package com.example.boschOrderManagementTask.service.interfaces;

import com.example.boschOrderManagementTask.Collection.User;

public interface UserServiceDao {

    User findByUserName(String userName);
}
