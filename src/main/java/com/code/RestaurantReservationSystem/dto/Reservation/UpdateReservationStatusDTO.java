package com.code.RestaurantReservationSystem.dto.Reservation;

import com.code.RestaurantReservationSystem.enums.Enums.ReservationStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

// created the DTO for the reservation status request can be sent to the server
@Data
public class UpdateReservationStatusDTO {
    @NotNull
    private ReservationStatus status;
}