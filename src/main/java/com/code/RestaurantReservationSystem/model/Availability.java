package com.code.RestaurantReservationSystem.model;

import java.time.LocalTime;

import com.code.RestaurantReservationSystem.enums.Enums.DayOfWeek;

import jakarta.persistence.*;
import lombok.*;

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

    @ManyToOne
    private Restaurant restaurant;
}
