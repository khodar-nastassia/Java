package com.andersen.coworking_reservation.service;

import com.andersen.coworking_reservation.model.Reservation;
import com.andersen.coworking_reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public void reserve(Reservation reservation) {
        repository.save(reservation);
    }

    public void cancel(int id) {
        repository.deleteById(id);
    }

    public List<Reservation> getByCustomerName(String customerName) {
        return repository.findByCustomerName(customerName);
    }

    public List<Reservation> getAll() {
        return repository.findAll();
    }

    public Optional<Reservation> getById(int id) {
        return repository.findById(id);
    }
}
