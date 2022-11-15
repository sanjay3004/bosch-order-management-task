package com.example.boschOrderManagementTask.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.Collection;

@Document
public class OrderComments {

    @Id
    String id;

    String comment;

    String orderId;
    String username;

    String userRole;

    LocalDateTime dateAndTime;

    public OrderComments(String comment, String orderId) {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        this.comment = comment;
        this.orderId = orderId;
        this.username = SecurityContextHolder.getContext().getAuthentication().getName();
        this.userRole = authorities.stream().findFirst().get().toString();
        dateAndTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public String getUserRole() {
        return userRole;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }
}
