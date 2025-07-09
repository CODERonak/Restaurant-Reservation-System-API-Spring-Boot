package com.code.RestaurantReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.RestaurantReservationSystem.model.Tables;
import com.code.RestaurantReservationSystem.model.Restaurant;

import java.util.List;

public interface TableRepository extends JpaRepository<Tables, Long> {
    List<Tables> findByRestaurant(Restaurant restaurant);

    List<Tables> findByRestaurantAndCapacityGreaterThanEqual(Restaurant restaurant, int capacity);
}