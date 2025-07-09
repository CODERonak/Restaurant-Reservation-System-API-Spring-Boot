package com.code.RestaurantReservationSystem.enums;

/*
 * Here all the required enums for the system has been implemneted
 * UserRole is used to define the role of the user
 * ReservationStatus is used to define the status of the reservation
 * TableStatus is used to define the status of the table
 * DayOfWeek is used to define the day of the week
 */

public class Enums {
    public enum UserRole {
        CUSTOMER,
        ADMIN,
        STAFF
    }

    public enum ReservationStatus {
        PENDING,
        CONFIRMED,
        CANCELLED
    }

    public enum TableStatus {
        AVAILABLE,
        BLOCKED
    }

    public enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}