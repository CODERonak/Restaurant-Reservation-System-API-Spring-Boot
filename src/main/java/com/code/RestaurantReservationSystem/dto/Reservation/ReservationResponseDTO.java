package com.code.RestaurantReservationSystem.dto.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.code.RestaurantReservationSystem.enums.Enums.ReservationStatus;

import lombok.Data;

@Data
public class ReservationResponseDTO {
    private Long id;
    private String reservationCode;
    private LocalTime reservationTime;
    private LocalDate reservationDate;
    private Integer numberOfPeople;
    private ReservationStatus status;
    private Long customerId;
    private Long restaurantId;
    private Long tableId;
    private String specialRequests;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
