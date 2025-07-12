package com.code.RestaurantReservationSystem.model;

import com.code.RestaurantReservationSystem.enums.Enums.TableStatus;

import jakarta.persistence.*;
import lombok.*;

/*
 * This model represents a table in the system
 * It is used to store table information in the database
 * The table is named "tables"
 * With details like table number, capacity, status, and restaurant
 */

@Entity
@Data
@Table(name = "tables")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer tableNumber;

    @Column(nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private TableStatus status; // AVAILABLE, BLOCKED

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurant_id")
    // This is the restaurant that the table belongs to
    private Restaurant restaurant;
}