package com.code.RestaurantReservationSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.RestaurantReservationSystem.dto.Restaurant.RestuarantRequestDTO;
import com.code.RestaurantReservationSystem.exceptions.custom.restaurant.RestaurantAlreadyExistsException;
import com.code.RestaurantReservationSystem.model.Restaurant;
import com.code.RestaurantReservationSystem.repository.RestaurantRepository;

// restaurant service to create, update and lists all the restaurants
@Service
public class RestaurantService {
    // creating the field and constructor
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // this method creates the restaurant and saves to the database
    public void createRestaurant(RestuarantRequestDTO request) {

        // checks if the restaurant already exists in the database
        // if doesn't exist throws an exception
        if (restaurantRepository.existsByEmail(request.getEmail())) {
            throw new RestaurantAlreadyExistsException("Restaurant already exists");
        }

        // creates a restaurant objects and saves to the database
        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setAddress(request.getAddress());
        restaurant.setPhoneNumber(request.getPhoneNumber());
        restaurant.setEmail(request.getEmail());
        restaurant.setDescription(request.getDescription());
        restaurant.setOpeningTime(request.getOpeningTime());
        restaurant.setClosingTime(request.getClosingTime());

        restaurantRepository.save(restaurant);
    }

    // this method updates the restaurant details and saves to the database
    // if doesn't exist throws an exception
    public void updateRestaurantDetails(Long restaurantId, RestuarantRequestDTO request) {
        Restaurant existingRestaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + restaurantId));

        existingRestaurant.setName(request.getName());
        existingRestaurant.setAddress(request.getAddress());
        existingRestaurant.setPhoneNumber(request.getPhoneNumber());
        existingRestaurant.setEmail(request.getEmail());
        existingRestaurant.setDescription(request.getDescription());
        existingRestaurant.setOpeningTime(request.getOpeningTime());
        existingRestaurant.setClosingTime(request.getClosingTime());

        restaurantRepository.save(existingRestaurant);
    }

    // this method lists all the restaurants in the database
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}