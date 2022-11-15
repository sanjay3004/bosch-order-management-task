package com.example.bosch_order_management_task.Collection;


import com.example.bosch_order_management_task.enums.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import java.util.Collection;
import java.util.List;

@Document
public class User implements UserDetails {

    @Id
    String id;
    String name;
    @Email
    String username;
    String password;
    Address address;

    List<GrantedAuthority> authorities;

    Role role;

    public User() {
    }

    public User(String name, String username, String password, Address address, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.address = address;
        this.role = role;
        this.authorities = List.of(new SimpleGrantedAuthority(role.name()));
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Address getAddress() {
        return address;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Role getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }
}
