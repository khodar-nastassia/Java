package com.andersen.coworking_reservation.dao;

import com.andersen.coworking_reservation.model.Workplace;
import java.util.List;

public interface WorkplaceDAO {
    List<Workplace> getAll();
    void add(Workplace workplace);
    void delete(int id);
    void updateIsAvailable(int id, boolean isAvailable);
    List<Workplace> getAvailableWorkplaces();
}






