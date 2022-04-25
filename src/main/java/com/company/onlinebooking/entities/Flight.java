package com.company.onlinebooking.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "flight")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "user"})
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Integer flightId;

    @Column(name = "flight_destination")
    private String destinationPoint;

    @Column(name = "flight_date")
    private LocalDate date;

    @Column(name = "flight_time")
    private LocalTime time;

    @Column(name="flight_free_seats")
    private Integer freeSeats;

    @OneToOne(mappedBy = "flight")
    private User user;

    public Flight(Integer flightId, String destinationPoint, LocalDate date, LocalTime time, Integer freeSeats) {
        this.flightId = flightId;
        this.destinationPoint = destinationPoint;
        this.date = date;
        this.time = time;
        this.freeSeats = freeSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Flight flight = (Flight) o;
        return flightId != null && Objects.equals(flightId, flight.flightId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}