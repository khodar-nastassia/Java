package com.andersen.coworking_reservation.service;

import com.andersen.coworking_reservation.model.Workplace;

import java.util.List;

public interface WorkplaceService {
    List<Workplace> getAll();
    void add(Workplace workplace);
    void delete(int id);
    void updateIsAvailable(int id, boolean isAvailable);
    List<Workplace> getAvailableWorkplaces();
}
