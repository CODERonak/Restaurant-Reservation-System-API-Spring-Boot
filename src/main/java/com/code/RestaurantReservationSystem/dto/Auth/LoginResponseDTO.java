package com.code.RestaurantReservationSystem.dto.Auth;

import lombok.AllArgsConstructor;
import lombok.Data;

// created the DTO for the login response can be sent to the client
@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
}