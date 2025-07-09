package com.code.RestaurantReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.RestaurantReservationSystem.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
