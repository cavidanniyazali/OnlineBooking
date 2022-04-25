package com.company.onlinebooking.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Integer id;
    private String passengerFirstName;
    private String passengerLastName;
    private Integer seatNumber;
}