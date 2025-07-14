package com.code.RestaurantReservationSystem.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.code.RestaurantReservationSystem.enums.Enums.ReservationStatus;

import jakarta.persistence.*;
import lombok.*;

/*
 * This model represents a reservation in the system
 * It is used to store reservation information in the database
 * The table is named "reservations"
 * With details like reservation code, reservation time, duration, party size, status, customer, restaurant, table, special requests, created at, and updated at
 */

@Entity
@Data
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String reservationCode;

    @Column(nullable = false)
    private LocalTime reservationTime;

    private LocalDate reservationDate;
    private Integer numberOfPeople;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status; // PENDING, CONFIRMED, CANCELLED

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Users customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private Tables table;

    // if any specific request to be added
    private String specialRequests;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}