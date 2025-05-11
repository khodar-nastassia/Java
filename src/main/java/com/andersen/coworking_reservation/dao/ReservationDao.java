package com.andersen.coworking_reservation.dao;

import com.andersen.coworking_reservation.model.Reservation;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ReservationDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public ReservationDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void reserve(Reservation reservation) {
        getSession().save(reservation);

    }

    public void cancel(int reservationId) {
        Reservation reservation = getSession().get(Reservation.class, reservationId);
        if (reservation != null) {
            getSession().delete(reservation);
        }
    }

    public List<Reservation> getByCustomerName(String customerName) {
        return getSession()
                .createQuery("FROM Reservation WHERE customerName = :name", Reservation.class)
                .setParameter("name", customerName)
                .getResultList();
    }

    public List<Reservation> getAll() {
        return getSession()
                .createQuery("FROM Reservation", Reservation.class)
                .getResultList();
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
