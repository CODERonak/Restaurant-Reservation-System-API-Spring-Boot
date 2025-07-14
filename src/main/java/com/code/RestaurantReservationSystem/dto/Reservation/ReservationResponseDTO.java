package com.code.RestaurantReservationSystem.dto.Reservation;

import java.time.LocalDateTime;

import com.code.RestaurantReservationSystem.enums.Enums.ReservationStatus;

import lombok.Data;

@Data
public class ReservationResponseDTO {
    private Long id;
    private String reservationCode;
    private LocalDateTime reservationTime;
    private Integer durationMinutes;
    private Integer partySize;
    private ReservationStatus status;
    private Long customerId;
    private Long restaurantId;
    private Long tableId;
    private String specialRequests;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
