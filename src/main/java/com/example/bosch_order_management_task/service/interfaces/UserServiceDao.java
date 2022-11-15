package com.example.bosch_order_management_task.service.interfaces;

import com.example.bosch_order_management_task.Collection.User;

public interface UserServiceDao {

    User findByUserName(String userName);
}
