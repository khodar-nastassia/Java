package com.andersen.coworking_reservation.service;

import com.andersen.coworking_reservation.dao.UserDAO;
import com.andersen.coworking_reservation.dao.WorkplaceDAO;
import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.model.Workplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkplaceServiceImpl implements WorkplaceService {
    @Autowired
    private final WorkplaceDAO workplaceDAO;


    public WorkplaceServiceImpl(WorkplaceDAO workplaceDAO) {
        this.workplaceDAO = workplaceDAO;
    }

    @Override
    public List<Workplace> getAll() {
        return workplaceDAO.getAll();
    }

    @Override
    public void add(Workplace workplace) {
        workplaceDAO.add(workplace);
    }

    @Override
    public void delete(int id) {
        workplaceDAO.delete(id);
    }

    @Override
    public void updateIsAvailable(int id, boolean isAvailable) {
        workplaceDAO.updateIsAvailable(id, isAvailable);
    }

    @Override
    public List<Workplace> getAvailableWorkplaces() {
        return workplaceDAO.getAvailableWorkplaces();
    }
}