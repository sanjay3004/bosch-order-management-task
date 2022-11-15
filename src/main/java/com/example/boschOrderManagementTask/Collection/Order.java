package com.example.boschOrderManagementTask.Collection;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Order {

    @Id
    String id;

    String productId;

    String buyerId;

    String sellerId;


    int currStatus=1;

    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    LocalDateTime dateTime;



    public Order(String productId, String buyerId, String sellerId) {
        this.productId = productId;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.dateTime=LocalDateTime.now();

    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }



    public int getCurrStatus() {
        return currStatus;
    }

    public void setCurrStatus(int currStatus) {
        this.currStatus = currStatus;
    }

    public String getId() {
        return id;
    }
}
