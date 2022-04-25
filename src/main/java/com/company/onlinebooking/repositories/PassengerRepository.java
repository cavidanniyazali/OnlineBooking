package com.company.onlinebooking.repositories;

import com.company.onlinebooking.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
}