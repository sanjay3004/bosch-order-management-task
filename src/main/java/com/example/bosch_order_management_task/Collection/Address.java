package com.example.bosch_order_management_task.Collection;

public class Address {

    String dNo;
    String city;
    String state;


    public Address(String dNo, String city, String state) {
        this.city = city;
        this.state = state;
        this.dNo = dNo;
    }

    public String getdNO() {
        return dNo;
    }

    public void setdNO(String dNO) {
        this.dNo = dNO;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


}
