package com.example.boschOrderManagementTask.dto;

import com.example.boschOrderManagementTask.Collection.Address;
import com.example.boschOrderManagementTask.Collection.enums.Role;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.Email;
import java.util.List;

public class UserDto {
    String id;

    String username;
    String name;
    String password;
    Address address;
    Role role;

    public UserDto(String username, String name, String password, Address address, Role role) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    public UserDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
