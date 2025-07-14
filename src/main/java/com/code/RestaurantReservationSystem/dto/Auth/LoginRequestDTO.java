package com.code.RestaurantReservationSystem.dto.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// created the DTO for the login request can be sent to the server
@Data
public class LoginRequestDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
