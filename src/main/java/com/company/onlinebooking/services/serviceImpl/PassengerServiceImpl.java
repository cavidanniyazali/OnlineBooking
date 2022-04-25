package com.company.onlinebooking.services.serviceImpl;

import com.company.onlinebooking.entities.Passenger;
import com.company.onlinebooking.entities.User;
import com.company.onlinebooking.repositories.PassengerRepository;
import com.company.onlinebooking.repositories.UserRepository;
import com.company.onlinebooking.services.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;
    private final UserRepository userRepository;

    @Override
    public String addPassenger(Integer id, Passenger passenger) {
        User user = this.userRepository.getById(id);
        passenger.setUser(user);
        this.passengerRepository.save(passenger);
        return "data added";
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return this.passengerRepository.findAll();
    }

    @Override
    public String deletePassenger(Integer id) {
        this.passengerRepository.deleteById(id);
        return "data removed";
    }
}