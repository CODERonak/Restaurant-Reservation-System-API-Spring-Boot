package com.code.RestaurantReservationSystem.dto.Auth;

import com.code.RestaurantReservationSystem.enums.Enums.UserRole;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequest {

    // These fields are optional and can be null
    private String firstName;
    private String lastName;

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