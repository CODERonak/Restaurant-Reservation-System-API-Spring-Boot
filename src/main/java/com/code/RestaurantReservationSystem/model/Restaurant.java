package com.code.RestaurantReservationSystem.model;

import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;

/*
 * This model represents a restaurant in the system
 * It is used to store restaurant information in the database
 * The table is named "restaurants"
 * With details like name, address, phone number, email, description, opening time, closing time, and owner
 */

@Entity
@Data
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalTime openingTime;

    @Column(nullable = false)
    private LocalTime closingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Users owner;
}