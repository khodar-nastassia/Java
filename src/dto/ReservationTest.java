package dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private Reservation setUpReservation() {
        return new Reservation("John", 1, "2025", "15", "19");

    }

    @Test
    @DisplayName("Should return correct workplace ID")
    void testGetWorkplaceIdMethod() {
        Reservation reservation = setUpReservation();
        assertEquals(1, reservation.getWorkplaceId());
    }

    @Test
    @DisplayName("Should return correct customer name")
    void testGetCustomerNameMethod() {
        Reservation reservation = setUpReservation();
        assertEquals("John", reservation.getCustomerName());
    }

    @Test
    @DisplayName("Should correctly assign unique ID")
    void testGetReservationIdMethod() {
        Reservation firstReservation = setUpReservation();
        Reservation secondReservation = setUpReservation();
        assertEquals(firstReservation.getId() + 1, secondReservation.getId(), "Each reservation ID should increment by 1");
    }

    @Test
    @DisplayName("Should throw exception for null customer name")
    void testNullCustomerName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reservation("", 1, "2025-04-15", "15:00", "19:00");
        });
    }

    @Test
    @DisplayName("Should throw exception for negative workplace ID")
    void testNegativeWorkplaceId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reservation("John", -5, "2025-04-15", "15:00", "19:00");
        });
    }

    @Test
    @DisplayName("Should throw exception for empty date string")
    void testEmptyDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Reservation("John", 1, "", "15:00", "19:00");
        });
    }


}

