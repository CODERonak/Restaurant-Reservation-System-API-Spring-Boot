package com.code.RestaurantReservationSystem.dto.Reservation;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

// created the DTO for the reservation request so the user can send the request to the server
@Data
public class ReservationRequestDTO {
    @NotNull
    private LocalTime reservationTime;

    private LocalDate reservationdDate;

    @NotNull
    private Integer numberOfPeople;

    @NotNull
    private Long customerId;

    @NotNull
    private Long restaurantId;

    @NotNull
    private Long tableId;

    private String specialRequests;
}