package com.code.RestaurantReservationSystem.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.code.RestaurantReservationSystem.model.Users;

// This class is used to load user details from the database
public class CustomUserDetails implements UserDetails {
    private final Users user;

    public CustomUserDetails(Users user) {
        this.user = user;
    }

    // this method lists the roles present in the userRole enum and adds them to the authorities list with ROLE_ 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().toString()));
        return authorities;
    }

    // this method returns the user's password
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // this method returns the user's username
    @Override
    public String getUsername() {
        return user.getUsername();
    }
}