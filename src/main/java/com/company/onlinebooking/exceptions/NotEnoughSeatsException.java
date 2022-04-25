package com.company.onlinebooking.exceptions;

public class NotEnoughSeatsException extends Exception {
    public NotEnoughSeatsException(String error) {
        super(error);
    }
}