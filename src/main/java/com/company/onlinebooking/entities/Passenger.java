package com.company.onlinebooking.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Integer passengerId;

    @Column(name = "passenger_first_name")
    private String firstName;

    @Column(name = "passenger_last_name")
    private String lastName;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Passenger passenger = (Passenger) o;
        return passengerId != null && Objects.equals(passengerId, passenger.passengerId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}