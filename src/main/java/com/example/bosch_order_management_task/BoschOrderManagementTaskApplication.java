package com.example.bosch_order_management_task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoschOrderManagementTaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BoschOrderManagementTaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       // Product product=new Product("phone","");

    }

}
