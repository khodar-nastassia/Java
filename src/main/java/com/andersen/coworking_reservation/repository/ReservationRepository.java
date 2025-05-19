package com.andersen.coworking_reservation.repository;

import com.andersen.coworking_reservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository  extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByCustomerName(String customerName);
}
