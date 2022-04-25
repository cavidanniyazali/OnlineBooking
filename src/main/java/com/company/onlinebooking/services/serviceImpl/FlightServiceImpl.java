package com.company.onlinebooking.services.serviceImpl;

import com.company.onlinebooking.entities.Flight;
import com.company.onlinebooking.repositories.FlightRepository;
import com.company.onlinebooking.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public String addFlight(Flight flight) {
        this.flightRepository.save(flight);
        return "data added";
    }

    @Override
    public List<Flight> getAllFlights() {
        return this.flightRepository.findAll();
    }

    @Override
    public String removeFlight(Integer id) {
        this.flightRepository.deleteById(id);
        return "data removed";
    }

    @Override
    public Flight getFlightById(Integer id) {
        return this.flightRepository.getById(id);
    }
}