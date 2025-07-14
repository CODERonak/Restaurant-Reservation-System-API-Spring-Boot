package com.code.RestaurantReservationSystem.dto.Reservation;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

// created the DTO for the reservation request so the user can send the request to the server
@Data
public class ReservationRequestDTO {
    @NotNull
    private LocalDateTime reservationTime;

    private Integer durationMinutes;

    @NotNull
    private Integer partySize;

    @NotNull
    private Long customerId;

    @NotNull
    private Long restaurantId;

    @NotNull
    private Long tableId;

    private String specialRequests;
}