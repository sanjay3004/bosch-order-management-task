package com.example.boschOrderManagementTask.dto;

public class CommentRequestDto {
    String comment;
    String orderId;

    public CommentRequestDto(String comment, String orderId) {
        this.comment = comment;
        this.orderId = orderId;
    }

    public CommentRequestDto() {

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
