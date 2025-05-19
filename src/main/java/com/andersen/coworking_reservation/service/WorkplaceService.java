package com.andersen.coworking_reservation.service;

import com.andersen.coworking_reservation.model.Workplace;
import com.andersen.coworking_reservation.repository.WorkplaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkplaceService {
    private final WorkplaceRepository repository;

    public WorkplaceService(WorkplaceRepository repository) {
        this.repository = repository;
    }

    public List<Workplace> getAllWorkplaces() {
        return repository.findAll();
    }

    public void addWorkplace(Workplace workplace) {
        repository.save(workplace);
    }

    public void deleteWorkplace(int id) {
        repository.deleteById(id);
    }

    public void updateAvailability(int id, boolean isAvailable) {
        Workplace workplace = repository.findById(id).orElse(null);
        if (workplace != null) {
            workplace.setIsAvailable(isAvailable);
            repository.save(workplace);
        }
    }

    public List<Workplace> getAvailableWorkplaces() {
        return repository.findByIsAvailableTrue();
    }
}
