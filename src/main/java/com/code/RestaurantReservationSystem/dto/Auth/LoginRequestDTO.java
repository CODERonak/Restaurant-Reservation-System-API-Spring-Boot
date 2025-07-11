package com.code.RestaurantReservationSystem.dto.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
