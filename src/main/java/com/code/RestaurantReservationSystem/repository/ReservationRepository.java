package com.code.RestaurantReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.RestaurantReservationSystem.model.Reservation;
import com.code.RestaurantReservationSystem.model.Restaurant;
import com.code.RestaurantReservationSystem.model.Users;
import java.time.LocalDateTime;
import java.util.List;

// This interface is used to define the methods for the reservation repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCustomer(Users customer);

    List<Reservation> findByRestaurantAndReservationTimeBetween(Restaurant restaurant, LocalDateTime startTime,
            LocalDateTime endTime);
}