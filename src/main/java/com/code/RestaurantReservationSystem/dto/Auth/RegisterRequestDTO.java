package com.code.RestaurantReservationSystem.dto.Auth;

import com.code.RestaurantReservationSystem.enums.Enums.UserRole;

import jakarta.validation.constraints.*;
import lombok.Data;

// This class represents a request to register a new user
@Data
public class RegisterRequestDTO {

    // These fields are optional and can be null
    private String firstName;
    private String lastName;

    // These fields are required and cannot be null
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

    @NotNull
    private UserRole role;
}