package com.code.RestaurantReservationSystem.dto.Restaurant;

import java.time.LocalTime;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RestuarantRequestDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String description;

    @NotNull
    private LocalTime openingTime;

    @NotNull
    private LocalTime closingTime;
}