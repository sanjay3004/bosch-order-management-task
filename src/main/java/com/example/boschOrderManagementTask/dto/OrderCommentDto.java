package com.example.boschOrderManagementTask.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

import java.time.LocalDateTime;
import java.util.Date;

public class OrderCommentDto {

    String comment;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateAndTime;

    String username;

    String userRole;

    public OrderCommentDto(String comment, LocalDateTime dateAndTime, String username, String userRole) {
        this.comment = comment;
        this.dateAndTime = dateAndTime;
        this.username = username;
        this.userRole = userRole;
    }

    public OrderCommentDto() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
