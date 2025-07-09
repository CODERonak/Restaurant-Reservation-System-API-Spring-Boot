package com.code.RestaurantReservationSystem.model;

import java.time.LocalDateTime;

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
    private LocalDateTime reservationTime;

    private Integer durationMinutes;
    private Integer partySize;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status; // PENDING, CONFIRMED, CANCELLED

    @ManyToOne
    private Users customer;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private Tables table;
    private String specialRequests;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}