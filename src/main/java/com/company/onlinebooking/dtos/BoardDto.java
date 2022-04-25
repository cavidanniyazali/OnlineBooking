package com.company.onlinebooking.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private Integer userId;
    private Integer numberOfPeople;
    private String destinationPoint;
    private LocalDate date;
    private LocalTime time;
}