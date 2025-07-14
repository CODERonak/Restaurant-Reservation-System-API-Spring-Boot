package com.code.RestaurantReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.RestaurantReservationSystem.model.Tables;
import com.code.RestaurantReservationSystem.model.Restaurant;

import java.util.List;

// This interface is used to define the methods for the table 
public interface TableRepository extends JpaRepository<Tables, Long> {
    List<Tables> findByRestaurantId(long restaurantId);

    List<Tables> findByRestaurantAndCapacityGreaterThanEqual(Restaurant restaurant, int capacity);
}