package com.company.onlinebooking.services.serviceImpl;

import com.company.onlinebooking.dtos.BoardDto;
import com.company.onlinebooking.entities.User;
import com.company.onlinebooking.repositories.FlightRepository;
import com.company.onlinebooking.repositories.UserRepository;
import com.company.onlinebooking.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    UserRepository userRepository;
    @Mock
    FlightRepository flightRepository;
    UserService userService;

    @BeforeEach
    void initUseCase() {
        userService = new UserServiceImpl(userRepository, flightRepository);
    }

    @Test
    void createUser() {
        Assertions.assertDoesNotThrow(() -> userService.createUser(Mockito.any()));
    }

    @Test
    void getAllUsers() {
        List<User> users = userRepository.findAll();
        Mockito.when(userService.getAllUsers()).thenReturn(users);
        Assertions.assertDoesNotThrow(() -> userRepository.findAll());
    }

    @Test
    void removeUser() {
        Assertions.assertDoesNotThrow(() -> userService.removeUser(Mockito.anyInt()));
    }

    @Test
    void book() {
        BoardDto boardDto = new BoardDto();
        Assertions.assertDoesNotThrow(() -> userService.book(Mockito.anyInt(), boardDto));
    }
}