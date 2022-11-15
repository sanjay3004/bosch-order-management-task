package com.example.boschOrderManagementTask.service;

import com.example.boschOrderManagementTask.Collection.User;
import com.example.boschOrderManagementTask.dto.UserDto;
import com.example.boschOrderManagementTask.repository.UserRepo;
import com.example.boschOrderManagementTask.service.interfaces.UserService;
import com.example.boschOrderManagementTask.service.interfaces.UserServiceDao;
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
