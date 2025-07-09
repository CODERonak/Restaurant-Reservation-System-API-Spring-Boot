package com.code.RestaurantReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.RestaurantReservationSystem.model.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

}
