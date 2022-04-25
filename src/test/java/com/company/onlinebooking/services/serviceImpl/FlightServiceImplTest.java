package com.company.onlinebooking.services.serviceImpl;

import com.company.onlinebooking.entities.Flight;
import com.company.onlinebooking.repositories.FlightRepository;
import com.company.onlinebooking.services.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {
    @Mock
    FlightRepository flightRepository;
    FlightService flightService;

    @BeforeEach
    void initUseCase() {
        flightService = new FlightServiceImpl(flightRepository);
    }

    @Test
    void addFlight() {
        Flight flight = new Flight();
        flight.setFlightId(3);
        flight.setDestinationPoint("Roma");
        flight.setDate(LocalDate.parse("2022-04-25"));
        Mockito.when(flightRepository.save(Mockito.any())).thenReturn(flight);
        Assertions.assertDoesNotThrow(() -> flightService.addFlight(flight));
    }

    @Test
    void getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        Mockito.when(flightService.getAllFlights()).thenReturn(flights);
        Assertions.assertDoesNotThrow(() -> flightService.getAllFlights());
    }

    @Test
    void removeFlight() {
        flightRepository.deleteById(1);
        Assertions.assertDoesNotThrow(() -> flightService.removeFlight(1));
    }

    @Test
    void getFlightById() {
        Flight flight = flightRepository.getById(1);
        when(flightService.getFlightById(Mockito.any())).thenReturn(flight);
        Assertions.assertDoesNotThrow(() -> flightService.getFlightById(1));
    }
}