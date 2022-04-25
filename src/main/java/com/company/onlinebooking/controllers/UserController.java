package com.company.onlinebooking.controllers;

import com.company.onlinebooking.dtos.BoardDto;
import com.company.onlinebooking.entities.User;
import com.company.onlinebooking.exceptions.FlightNotFoundException;
import com.company.onlinebooking.exceptions.NotEnoughSeatsException;
import com.company.onlinebooking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @PostMapping(value = "/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok(this.userService.createUser(user));
    }

    @DeleteMapping(value = "/removeUser/{id}")
    public ResponseEntity<String> removeUser(@PathVariable Integer id) {
        return ResponseEntity.ok(this.userService.removeUser(id));
    }

    @PostMapping(value = "/book")
    public ResponseEntity<String> book(
            @RequestParam Integer flightId,
            @RequestBody BoardDto boardDto) throws FlightNotFoundException, NotEnoughSeatsException {
        return ResponseEntity.ok(this.userService.book(flightId, boardDto));
    }
}