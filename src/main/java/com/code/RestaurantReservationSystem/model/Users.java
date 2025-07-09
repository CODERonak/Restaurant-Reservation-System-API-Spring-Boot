package com.code.RestaurantReservationSystem.model;

import com.code.RestaurantReservationSystem.enums.Enums.UserRole;

import jakarta.persistence.*;
import lombok.*;

/*
    This model represents a user in the system
    It is used to store user information in the database
    The table is named "users"
    With details like username, password, email, first name, last name, phone number, and role
 */

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // These fields are optional and can be null
    private String firstName;
    private String lastName;

    // These fields are required and cannot be null
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}