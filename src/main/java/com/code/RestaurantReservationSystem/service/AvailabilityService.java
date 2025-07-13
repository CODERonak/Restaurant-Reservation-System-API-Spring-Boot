package com.code.RestaurantReservationSystem.service;

import org.springframework.stereotype.Service;

import com.code.RestaurantReservationSystem.dto.Table.AvailabilityDTO;
import com.code.RestaurantReservationSystem.model.Availability;
import com.code.RestaurantReservationSystem.model.Restaurant;
import com.code.RestaurantReservationSystem.repository.AvailabilityRepository;

@Service
public class AvailabilityService {
    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    public void createAvailability(AvailabilityDTO availability, Long restaurantId) {
        Availability newAvailability = new Availability();
        Restaurant restaurant = new Restaurant();

        restaurant.setId(availability.getRestaurantId());
        newAvailability.setRestaurant(restaurant);
        newAvailability.setDayOfWeek(availability.getDayOfWeek());
        newAvailability.setOpeningTime(availability.getOpeningTime());
        newAvailability.setClosingTime(availability.getClosingTime());

        availabilityRepository.save(newAvailability);
    }

}