package com.code.RestaurantReservationSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.code.RestaurantReservationSystem.jwt.JWTEntryPoint;
import com.code.RestaurantReservationSystem.jwt.JWTFilter;
import com.code.RestaurantReservationSystem.jwt.JWTUtil;
import com.code.RestaurantReservationSystem.service.CustomUserDetailsService;

// This class is used to configure the security of the application
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // This is used to authorize requests
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/auth/**", "/admin/restaurant/all").permitAll()
                .requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers("/tables/**", "/availability/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_STAFF")
                .anyRequest().authenticated())

                // This is used to enable basic authentication
                .httpBasic(Customizer.withDefaults())
                .formLogin(form -> form.disable())
                .authenticationManager(authenticationManager())
                .csrf(csrf -> csrf.disable())
                .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(jwtEntryPoint));

        return http.build();
    }

    // creating the fields for the class
    private final CustomUserDetailsService userDetailsService;
    private final JWTEntryPoint jwtEntryPoint;
    private final JWTUtil jwtUtil;

    // creating the constructor for the class
    public SecurityConfig(CustomUserDetailsService userDetailsService, JWTEntryPoint jwtEntryPoint, JWTUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtEntryPoint = jwtEntryPoint;
        this.jwtUtil = jwtUtil;
    }

    // This function is used to filter the requests
    @Bean
    public JWTFilter authenticationJwtTokenFilter() {
        return new JWTFilter(jwtUtil, userDetailsService);
    }

    // This is used to authenticate users
    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authenticationProvider);
    }

    // this function helps to return a password in Bcrypt enecoded form
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}