package com.code.RestaurantReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.RestaurantReservationSystem.model.Restaurant;

// This interface is used to access the database and check if the email already exists
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    boolean existsByEmail(String email);
}
