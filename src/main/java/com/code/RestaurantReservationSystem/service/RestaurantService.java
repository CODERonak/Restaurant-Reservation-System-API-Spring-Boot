package com.code.RestaurantReservationSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.code.RestaurantReservationSystem.dto.Restaurant.RestuarantRequestDTO;
import com.code.RestaurantReservationSystem.exceptions.custom.restaurant.RestaurantAlreadyExistsException;
import com.code.RestaurantReservationSystem.model.Restaurant;
import com.code.RestaurantReservationSystem.repository.RestaurantRepository;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public void createRestaurant(RestuarantRequestDTO request) {

        if (restaurantRepository.existsByEmail(request.getEmail())) {
            throw new RestaurantAlreadyExistsException("Restaurant already exists");
        }

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

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}