package com.example.bosch_order_management_task.Collection;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Product {

    @Id
    String id;

    String name;
    double price;

    String sellerId;
    int available;

    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    LocalDateTime dateTime;

    public Product(String name, String sellerId, double price, int available) {
        this.sellerId = sellerId;
        this.name = name;
        this.price = price;
        this.available = available;
        this.dateTime = LocalDateTime.now();
    }

    public Product() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}

