package com.code.RestaurantReservationSystem.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.code.RestaurantReservationSystem.dto.Reservation.ReservationRequestDTO;
import com.code.RestaurantReservationSystem.enums.Enums.ReservationStatus;
import com.code.RestaurantReservationSystem.model.*;
import com.code.RestaurantReservationSystem.repository.*;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final TableRepository tableRepository;

    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository,
            RestaurantRepository restaurantRepository, TableRepository tableRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.tableRepository = tableRepository;
    }

    // This method is used to create a reservation
    public void createReservation(ReservationRequestDTO request) {

        // Find the customer, restaurant, and table by their IDs
        Users customer = userRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Tables table = tableRepository.findById(request.getTableId())
                .orElseThrow(() -> new RuntimeException("Table not found"));

        Reservation reservation = new Reservation();
        reservation.setCustomer(customer);
        reservation.setRestaurant(restaurant);
        reservation.setTable(table);
        reservation.setReservationCode(getReservationCode());
        reservation.setStatus(ReservationStatus.PENDING);
        reservation.setReservationTime(request.getReservationTime());
        reservation.setReservationDate(request.getReservationDate());
        reservation.setNumberOfPeople(request.getNumberOfPeople());
        reservation.setSpecialRequests(request.getSpecialRequests());
        reservation.setCreatedAt(LocalDateTime.now());
        reservation.setUpdatedAt(LocalDateTime.now());

        reservationRepository.save(reservation);
    }

    public void updateReservationStatus(Long reservationId, ReservationStatus status) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));

        reservation.setStatus(status);
        reservation.setUpdatedAt(LocalDateTime.now());

        reservationRepository.save(reservation);
    }

    public String getReservationCode() {
        return "RES-" + System.currentTimeMillis();
    }
}