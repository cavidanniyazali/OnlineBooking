package com.company.onlinebooking.services;

import com.company.onlinebooking.entities.Flight;

import java.util.List;

public interface FlightService {
    String addFlight(Flight flight);

    List<Flight> getAllFlights();

    String removeFlight(Integer id);

    Flight getFlightById(Integer id);
}