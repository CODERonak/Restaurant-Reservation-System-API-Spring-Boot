package com.code.RestaurantReservationSystem.model;

import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "restaurants")
public class Restaurant {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private String address;
    private String phoneNumber;
    private String email;
    private String description;

    private LocalTime openingTime;
    private LocalTime closingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Users owner;
}