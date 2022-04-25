package com.company.onlinebooking.services;

import com.company.onlinebooking.entities.Passenger;

import java.util.List;

public interface PassengerService {
    String addPassenger(Integer id, Passenger passenger);

    List<Passenger> getAllPassengers();

    String deletePassenger(Integer id);


}