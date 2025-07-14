package com.code.RestaurantReservationSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.RestaurantReservationSystem.model.Users;

// This interface is used to perform CRUD operations on the database with custom methods
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    // custom methods
    Optional<Users> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    Users findByEmail(String email);
}