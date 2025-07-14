package com.code.RestaurantReservationSystem.dto.Restaurant;

import java.time.LocalTime;

import lombok.Data;

// created the DTO for the restaurant response can be sent to the client
@Data
public class RestaurantResponseDTO {
    // fields to be sent to the client
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String description;
    private LocalTime openingTime;
    private LocalTime closingTime;
}