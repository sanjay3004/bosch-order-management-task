package com.example.boschOrderManagementTask.service;


import com.example.boschOrderManagementTask.Collection.User;
import com.example.boschOrderManagementTask.repository.UserRepo;
import com.example.boschOrderManagementTask.service.interfaces.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDaoImpl implements UserServiceDao {

    @Autowired
    UserRepo userRepository;
    @Override
    public User findByUserName(String userName) {
        List<User> all = userRepository.findAll();
        for(User user:all){
            if(user.getUsername().equalsIgnoreCase(userName)){
                return user;
            }
        }
        return null;
    }


}
