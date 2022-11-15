package com.example.boschOrderManagementTask.Collection;


import com.example.boschOrderManagementTask.Collection.enums.Status;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class OrderStatus {

    @Id
    String id;

    String orderId;
    Status status;

    LocalDateTime dateAndTime;

    public OrderStatus(Status status, String orderId) {
        this.status = status;
        this.orderId = orderId;
        dateAndTime = LocalDateTime.now();
    }

    public String getOrderId() {
        return orderId;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }
}
