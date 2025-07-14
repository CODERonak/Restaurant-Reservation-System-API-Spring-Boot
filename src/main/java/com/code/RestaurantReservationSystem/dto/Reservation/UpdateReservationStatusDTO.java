package com.code.RestaurantReservationSystem.dto.Reservation;

import com.code.RestaurantReservationSystem.enums.Enums.ReservationStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateReservationStatusDTO {
    @NotNull
    private ReservationStatus status;
}