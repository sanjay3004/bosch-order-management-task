package com.example.bosch_order_management_task.service;

import com.example.bosch_order_management_task.Collection.User;
import com.example.bosch_order_management_task.dto.UserDto;
import com.example.bosch_order_management_task.repository.UserRepo;
import com.example.bosch_order_management_task.service.interfaces.UserService;
import com.example.bosch_order_management_task.service.interfaces.UserServiceDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    UserServiceDao userServiceDao;

    ModelMapper modelMapper=new ModelMapper();

    @Autowired
    UserRepo userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userServiceDao.findByUserName(username);
    }

    public User addUser(User user){
        User user1=new User(user.getName(),user.getUsername(),user.getPassword(),user.getAddress(),user.getRole());

        return userRepository.save(user1);
    }

    public List<UserDto> getUser(){
        return userRepository.findAll().stream().map(e->mapper(e)).collect(Collectors.toList());
    }

    public UserDto mapper(User user){
            return modelMapper.map(user,UserDto.class);
    }
}
