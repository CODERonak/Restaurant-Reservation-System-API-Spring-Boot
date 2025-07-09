package com.code.RestaurantReservationSystem.model;

import com.code.RestaurantReservationSystem.enums.Enums.TableStatus;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "tables")
public class Tables {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer tableNumber;

    @Column(nullable = false)
    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private TableStatus status; // AVAILABLE, BLOCKED

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    // This is the restaurant that the table belongs to
    private Restaurant restaurant;
}