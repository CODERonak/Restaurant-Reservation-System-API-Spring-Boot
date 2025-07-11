package com.code.RestaurantReservationSystem.dto.Restaurant;

import java.time.LocalTime;

import lombok.Data;

@Data
public class RestaurantResponseDTO {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String description;
    private LocalTime openingTime;
    private LocalTime closingTime;
}