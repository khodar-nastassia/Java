package com.andersen.coworking_reservation.repository;

import com.andersen.coworking_reservation.model.Workplace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
    List<Workplace> findByIsAvailableTrue();
}
