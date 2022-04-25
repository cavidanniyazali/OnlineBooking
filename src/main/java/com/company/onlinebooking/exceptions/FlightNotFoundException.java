package com.company.onlinebooking.exceptions;

public class FlightNotFoundException extends Exception {
    public FlightNotFoundException(String error){
        super(error);
    }
}