package com.code.RestaurantReservationSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.code.RestaurantReservationSystem.dto.Reservation.ReservationRequestDTO;
import com.code.RestaurantReservationSystem.dto.Reservation.UpdateReservationStatusDTO;
import com.code.RestaurantReservationSystem.enums.Enums.ReservationStatus;
import com.code.RestaurantReservationSystem.service.ReservationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReservations(@RequestBody ReservationRequestDTO request) {
        reservationService.createReservation(request);
        return new ResponseEntity<>("Reservation created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateReservationStatus(@PathVariable Long id,
            @RequestBody @Valid UpdateReservationStatusDTO request) {
        reservationService.updateReservationStatus(id, request.getStatus());
        return ResponseEntity.ok("Reservation updated successfully");
    }

}