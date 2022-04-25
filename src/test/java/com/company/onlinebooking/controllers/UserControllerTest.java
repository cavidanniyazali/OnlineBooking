package com.company.onlinebooking.controllers;

import com.company.onlinebooking.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Test
    void getAllUsers() throws Exception {
        Assertions.assertDoesNotThrow(() -> userController.getAllUsers());
    }

    @Test
    void creatUser() throws Exception {
        Assertions.assertDoesNotThrow(() -> userController.createUser(Mockito.any()));
    }

    @Test
    void removeUser() throws Exception {
        Assertions.assertDoesNotThrow(() -> userController.removeUser(Mockito.any()));
    }

    @Test
    void book() throws Exception {
        Assertions.assertDoesNotThrow(() -> userController.book(Mockito.anyInt(), Mockito.any()));
    }
}