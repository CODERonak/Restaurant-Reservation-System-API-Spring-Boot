package com.code.RestaurantReservationSystem.enums;

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