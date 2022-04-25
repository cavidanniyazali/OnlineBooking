package com.company.onlinebooking.services.serviceImpl;

import com.company.onlinebooking.entities.Passenger;
import com.company.onlinebooking.repositories.PassengerRepository;
import com.company.onlinebooking.repositories.UserRepository;
import com.company.onlinebooking.services.PassengerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class PassengerServiceImplTest {
    @Mock
    PassengerRepository passengerRepository;
    @Mock
    UserRepository userRepository;
    PassengerService passengerService;

    @BeforeEach
    void initUseCase() {
        passengerService = new PassengerServiceImpl(passengerRepository, userRepository);
    }

    @Test
    @MockitoSettings(strictness = Strictness.LENIENT)
    void addPassenger() {
        Passenger passenger = new Passenger();
        Assertions.assertDoesNotThrow(() -> passengerService.addPassenger(Mockito.anyInt(), passenger));
    }

    @Test
    void getAllPassengers() {
        List<Passenger> flights = passengerRepository.findAll();
        Mockito.when(passengerService.getAllPassengers()).thenReturn(flights);
        Assertions.assertDoesNotThrow(() -> passengerService.getAllPassengers());
    }

    @Test
    void deletePassenger() {
        passengerRepository.deleteById(1);
        Assertions.assertDoesNotThrow(() -> passengerService.deletePassenger(1));
    }
}