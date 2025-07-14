package com.code.RestaurantReservationSystem.dto.Table;

import java.time.LocalTime;

import com.code.RestaurantReservationSystem.enums.Enums.DayOfWeek;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

// this dto is used to send the availability of the restaurant to the client with validation
@Data
public class AvailabilityDTO {
    @NotNull
    private DayOfWeek dayOfWeek;

    @NotNull
    private LocalTime openingTime;

    @NotNull
    private LocalTime closingTime;

    @NotNull
    private Long restaurantId;
}