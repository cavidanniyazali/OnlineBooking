package com.company.onlinebooking.controllers;

import com.company.onlinebooking.entities.Passenger;
import com.company.onlinebooking.services.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passenger")
@RequiredArgsConstructor
public class PassengerController {
    public final PassengerService passengerService;

    @GetMapping(value = "/getAllPassengers")//+
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return ResponseEntity.ok(this.passengerService.getAllPassengers());
    }

    @PostMapping(value = "/addPassenger")
    public ResponseEntity<String> addPassenger(
            @RequestParam Integer id,
            @RequestBody Passenger passenger) {
        return ResponseEntity.ok(this.passengerService.addPassenger(id,passenger));
    }

    @DeleteMapping(value = "/removePassenger/{id}")
    public ResponseEntity<String> removePassenger(@PathVariable Integer id) {
        return ResponseEntity.ok(this.passengerService.deletePassenger(id));
    }
}