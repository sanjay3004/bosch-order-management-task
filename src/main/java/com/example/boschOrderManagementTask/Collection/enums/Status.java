package com.example.boschOrderManagementTask.Collection.enums;

public enum Status {
    ORDER_PLACED,
    ORDER_CONFIRMED,
    READY_TO_SHIP,
    POD_UPLOADED,
    BUYER_APPROVED,
    PAYMENT_PROCESSED;


    public Status get(int i){
        Status[] values = values();
        return values[i];
    }

    

}
