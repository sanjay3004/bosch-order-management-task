package com.example.boschOrderManagementTask.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class OrderStatusDto {

    String status;
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    LocalDateTime dateAndTime;

    public OrderStatusDto(String status) {
        this.status = status;
        this.dateAndTime=LocalDateTime.now();
    }

    public OrderStatusDto() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
