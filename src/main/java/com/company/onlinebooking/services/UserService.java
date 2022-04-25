package com.company.onlinebooking.services;

import com.company.onlinebooking.dtos.BoardDto;
import com.company.onlinebooking.entities.User;
import com.company.onlinebooking.exceptions.FlightNotFoundException;
import com.company.onlinebooking.exceptions.NotEnoughSeatsException;

import java.util.List;

public interface UserService {
    String createUser(User user);

    List<User> getAllUsers();

    String removeUser(Integer id);

    String  book(Integer id, BoardDto boardDto) throws FlightNotFoundException, NotEnoughSeatsException;
}