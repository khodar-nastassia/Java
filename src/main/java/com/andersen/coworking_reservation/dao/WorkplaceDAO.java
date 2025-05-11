package com.andersen.coworking_reservation.dao;

import com.andersen.coworking_reservation.model.Workplace;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Repository
@Transactional
public class WorkplaceDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public WorkplaceDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public List<Workplace> getAll() {
        return getSession()
                .createQuery("FROM Workplace", Workplace.class)
                .getResultList();
    }

    public void add(Workplace workplace) {
        getSession().save(workplace);
    }

    public void delete(int id) {
        Workplace workplace = getSession().get(Workplace.class, id);
        if (workplace != null) {
            getSession().delete(workplace);
        }
    }

    public void updateIsAvailable(int id, boolean isAvailable) {
        Workplace workplace = getSession().get(Workplace.class, id);
        if (workplace != null) {
            workplace.setIsAvailable(isAvailable);
            getSession().update(workplace);
        }
    }

    public List<Workplace> getAvailableWorkplaces() {
        return getSession()
                .createQuery("FROM Workplace WHERE isAvailable = true", Workplace.class)
                .getResultList();
    }
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
