package com.company.onlinebooking;

import com.company.onlinebooking.controllers.PassengerController;
import com.company.onlinebooking.services.PassengerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineBookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookingApplication.class, args);
    }
}
