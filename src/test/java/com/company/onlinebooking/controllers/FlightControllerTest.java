package com.company.onlinebooking.controllers;

import com.company.onlinebooking.entities.Flight;
import com.company.onlinebooking.services.FlightService;
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
class FlightControllerTest {
    @Mock
    private FlightService flightService;
    @InjectMocks
    private FlightController flightController;

    @Test
    void getAllFlights() throws Exception {
        Assertions.assertDoesNotThrow(() -> flightController.getAllFlights());
    }

    @Test
    void getFlightById() throws Exception {
        Assertions.assertDoesNotThrow(() -> flightController.getFlightById(1));
    }

    @Test
    void removeFlight() {
        Assertions.assertDoesNotThrow(() -> flightController.removeFlight(Mockito.anyInt()));
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void addFlight() throws Exception {
        Flight flight = new Flight();
        Mockito.when(flightService.getFlightById(Mockito.anyInt())).thenReturn(flight);
        Assertions.assertDoesNotThrow(() -> flightController.addFlight(Mockito.any()));
    }
}