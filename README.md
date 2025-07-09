Here's a comprehensive `README.md` for your Restaurant Reservation System API, ready for your GitHub repository\!

-----



# 🍽️ Restaurant Reservation System API

**NOTE: This API is still under development.**

-----

## 🎯 Objective

This project delivers a **Restaurant Reservation System API** built with Spring Boot. It adheres to clean architecture principles, RESTful design, and robust security, providing a solid foundation for managing restaurant reservations. 

-----

## ✨ Features

  * **User Management & Authentication:** Secure registration and login for `CUSTOMER`, `STAFF`, and `ADMIN` roles.
  * **Restaurant Management:** Create, update, and manage restaurant details by staff and administrators.
  * **Table Management:** Define and manage tables within restaurants, including capacity and blocking capabilities.
  * **Availability Configuration:** Staff can set and update daily operating hours for restaurants.
  * **Reservation System:** Customers can make, view, update, and cancel reservations. Staff can manage reservation statuses.
  * **Search & Discovery:** Public endpoints for searching restaurants and checking available reservation slots.
  * **JWT Security:** Stateless authentication using JSON Web Tokens for secure API access.
  <!-- * **Email Notifications:** Basic integration for sending email confirmations or reminders. -->
  * **Global Exception Handling:** Consistent error handling across the API.
  * **Database Support:** Configured for MySQL.

-----

## 🛠️ Technologies Used

  * **Spring Boot:** Framework for building robust, stand-alone, production-grade Spring applications.
  * **Spring Data JPA:** For simplified data access and persistence with Hibernate.
  * **Spring Security:** Comprehensive security services for Java EE-based enterprise software applications.
  * **PostgreSQL:** Relational database for production environments.
  * **Java 21:** The core programming language.
  * **Lombok:** Reduces boilerplate code (getters, setters, constructors).
  * **JJWT (or Custom Util):** For JSON Web Token generation and validation.
  * **Postman:** For API testing and development.
  * **Git & GitHub:** Version control and hosting.

-----

## 📦 Project Structure

The project follows a modular structure, promoting separation of concerns and maintainability:

```
src/
└── main/
    ├── java/
    │   └── com.example.restaurantreservationsystem/
    │       ├── RestaurantReservationSystemApplication.java
    │       ├── controller/      // REST controllers exposing API endpoints
    │       ├── service/         // Business logic and transaction management
    │       ├── repository/      // Spring Data JPA interfaces for data access
    │       ├── model/           // JPA entities representing database tables
    │       ├── dto/             // Data Transfer Objects for request/response payloads
    │       ├── config/          // Security and application-specific configurations
    │       ├── exception/       // Custom and global exception handlers
    │       └── enums/           // Enumerations for user roles, reservation statuses, etc.
    └── resources/
        └── application.properties (or .yml) // Application configurations
```

## 🔑 Security & Authentication

The API uses **JWT (JSON Web Tokens)** for stateless authentication.

### Public Endpoints

  * `POST /api/auth/register`
  * `POST /api/auth/login`
  * `GET /api/search/restaurants`
  * `GET /api/restaurants/{id}/available-slots`

### Protected Endpoints

All other endpoints require a valid JWT in the `Authorization: Bearer <token>` header. Roles (`ROLE_CUSTOMER`, `ROLE_STAFF`, `ROLE_ADMIN`) are enforced for specific endpoints.

## 🌐 API Endpoints

Here's a summary of the main API endpoints. Refer to the codebase for detailed request/response DTOs.

### Authentication

  * `POST /api/auth/register` - Register a new user.
  * `POST /api/auth/login` - Authenticate user and receive JWT.

### Restaurant Management (STAFF, ADMIN)

  * `POST /api/restaurants` - Create a new restaurant.
  * `PUT /api/restaurants/{id}` - Update an existing restaurant.
  * `GET /api/restaurants/my` - Get restaurants owned by the authenticated user (staff/admin).

### Table Management (STAFF, ADMIN)

  * `POST /api/restaurants/{restaurantId}/tables` - Add a table to a specific restaurant.
  * `PUT /api/tables/{tableId}` - Update a table.
  * `PUT /api/tables/{tableId}/block` - Block/unblock a table.

### Availability Management (STAFF, ADMIN)

  * `POST /api/restaurants/{restaurantId}/availability` - Set daily availability for a restaurant.
  * `PUT /api/availability/{availabilityId}` - Update existing availability.

### Reservation Management

  * `POST /api/reservations` (CUSTOMER) - Create a new reservation.
  * `PUT /api/reservations/{id}` (CUSTOMER) - Update an existing reservation.
  * `DELETE /api/reservations/{id}` (CUSTOMER) - Cancel a reservation.
  * `GET /api/reservations/my` (CUSTOMER) - Get current user's reservations.
  * `GET /api/restaurants/{id}/reservations` (STAFF) - Get all reservations for a specific restaurant.
  * `PUT /api/reservations/{id}/status` (STAFF) - Update reservation status (e.g., CONFIRMED, CANCELED, COMPLETED).

### Search & Public Access

  * `GET /api/search/restaurants` - Search restaurants by various criteria (e.g., name, cuisine).
  * `GET /api/restaurants/{id}/available-slots` - Get available reservation slots for a given restaurant.

```

-----