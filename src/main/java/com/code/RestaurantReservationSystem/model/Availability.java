package com.code.RestaurantReservationSystem.model;

import java.time.LocalTime;

import com.code.RestaurantReservationSystem.enums.Enums.DayOfWeek;

import jakarta.persistence.*;
import lombok.*;

/*
 * This model represents the availability of a restaurant on a specific day of the week
 * It is used to store availability information in the database
 * The table is named "available"
 * With details like day of the week, opening time, closing time, and restaurant
 */

@Entity
@Data
@Table(name = "available")
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;

    private LocalTime openingTime;
    private LocalTime closingTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
