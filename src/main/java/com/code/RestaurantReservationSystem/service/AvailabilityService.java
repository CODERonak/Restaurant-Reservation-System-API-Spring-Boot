package com.code.RestaurantReservationSystem.service;

import org.springframework.stereotype.Service;

import com.code.RestaurantReservationSystem.dto.Table.AvailabilityDTO;
import com.code.RestaurantReservationSystem.model.Availability;
import com.code.RestaurantReservationSystem.model.Restaurant;
import com.code.RestaurantReservationSystem.repository.AvailabilityRepository;

// This service is used to create and update the availability of the restaurant
@Service
public class AvailabilityService {
    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    // this method is used to create the availability of the restaurant
    public void createAvailability(AvailabilityDTO availability, Long restaurantId) {
        // this create a new availability and restaurant object and set's the restaurant id
        Availability newAvailability = new Availability();
        Restaurant restaurant = new Restaurant();

        // this sets the restaurant id and saves the availability to the database
        restaurant.setId(availability.getRestaurantId());
        newAvailability.setRestaurant(restaurant);
        newAvailability.setDayOfWeek(availability.getDayOfWeek());
        newAvailability.setOpeningTime(availability.getOpeningTime());
        newAvailability.setClosingTime(availability.getClosingTime());

        availabilityRepository.save(newAvailability);
    }

    // this method updates the availability of the restaurant
    public void updateAvailability(AvailabilityDTO availability, Long availabilityId) {
        // this finds the availability by id and updates the availability 
        // and saves it to the database and throws an exception if the availability is not found
        Availability existingAvailability = availabilityRepository.findById(availabilityId)
                .orElseThrow(() -> new IllegalArgumentException("Availability not found with id: " + availabilityId));

                // updates the opening time and closing time
        existingAvailability.setOpeningTime(availability.getOpeningTime());
        existingAvailability.setClosingTime(availability.getClosingTime());
        availabilityRepository.save(existingAvailability);
    }

}