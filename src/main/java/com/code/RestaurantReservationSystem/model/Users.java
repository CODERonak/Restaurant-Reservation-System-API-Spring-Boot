package com.code.RestaurantReservationSystem.model;

import com.code.RestaurantReservationSystem.enums.Enums.UserRole;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String firstName;
    private String lastName;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}