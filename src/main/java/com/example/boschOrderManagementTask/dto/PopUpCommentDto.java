package com.example.boschOrderManagementTask.dto;

import com.example.boschOrderManagementTask.Collection.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class PopUpCommentDto {

    Status status;
    String comment;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime dateAndTime;

    public PopUpCommentDto(Status status, String comment, LocalDateTime dateAndTime) {
        this.status = status;
        this.comment = comment;
        this.dateAndTime = dateAndTime;
    }

    public PopUpCommentDto() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
}
