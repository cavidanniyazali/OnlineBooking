package com.company.onlinebooking.services.serviceImpl;

import com.company.onlinebooking.dtos.BoardDto;
import com.company.onlinebooking.entities.Flight;
import com.company.onlinebooking.entities.User;
import com.company.onlinebooking.exceptions.FlightNotFoundException;
import com.company.onlinebooking.exceptions.NotEnoughSeatsException;
import com.company.onlinebooking.repositories.FlightRepository;
import com.company.onlinebooking.repositories.UserRepository;
import com.company.onlinebooking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final FlightRepository flightRepository;

    @Override
    public String createUser(User user) {
        this.userRepository.save(user);
        return "data added";
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public String removeUser(Integer id) {
        this.userRepository.deleteById(id);
        return "data removed";
    }

    @Override
    public String book(Integer id, BoardDto boardDto) throws FlightNotFoundException, NotEnoughSeatsException {
        Optional<Flight> flight = flightRepository.findByFlightId(id);
        User user = this.userRepository.getById(boardDto.getUserId());
        if (flight.isPresent()) {
            if (flight.get().getFreeSeats() < boardDto.getNumberOfPeople()) {
                throw new NotEnoughSeatsException("there is not enough seat");
            }
            user.setFlight(flight.get());
            flight.get().setFreeSeats(flight.get().getFreeSeats() - boardDto.getNumberOfPeople());
            this.userRepository.save(user);
            return "successfully booked";
        } else {
            throw new FlightNotFoundException("flight not found");
        }
    }
}