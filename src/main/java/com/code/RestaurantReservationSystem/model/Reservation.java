package com.code.RestaurantReservationSystem.model;

import java.time.LocalDateTime;

import com.code.RestaurantReservationSystem.enums.Enums.ReservationStatus;

import jakarta.persistence.*;
import lombok.*;

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