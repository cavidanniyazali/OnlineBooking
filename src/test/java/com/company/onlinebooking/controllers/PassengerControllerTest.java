package com.company.onlinebooking.controllers;

import com.company.onlinebooking.entities.Passenger;
import com.company.onlinebooking.services.PassengerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
class PassengerControllerTest {
    @Mock
    private PassengerService passengerService;
    @InjectMocks
    private PassengerController passengerController;

    @Test
    void getAllPassengers() throws Exception {
        Assertions.assertDoesNotThrow(() -> passengerController.getAllPassengers());
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void addPassenger() throws Exception {
        Passenger passenger = new Passenger();
        Assertions.assertDoesNotThrow(() -> passengerController.addPassenger(Mockito.anyInt(), Mockito.any()));
    }

    @Test
    void removePassenger() throws Exception {
        Assertions.assertDoesNotThrow(() -> passengerController.removePassenger(Mockito.any()));
    }
}