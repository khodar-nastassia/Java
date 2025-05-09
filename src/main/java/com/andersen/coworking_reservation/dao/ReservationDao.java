package com.andersen.coworking_reservation.dao;

import com.andersen.coworking_reservation.db.HibernateUtil;
import com.andersen.coworking_reservation.model.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class ReservationDao {
    public void reserve(String customerName, int workplaceId, String date, String startTime, String endTime) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Reservation reservation = new Reservation(customerName, workplaceId, date, startTime, endTime);
            session.persist(reservation);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void cancel(int reservationId) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Reservation reservation = session.get(Reservation.class, reservationId);
            if (reservation != null) {
                session.delete(reservation);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Reservation> getByCustomerName(String customerName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Reservation> query = session.createQuery(
                    "FROM Reservation WHERE customerName = :customerName", Reservation.class);
            query.setParameter("customerName", customerName);
            return query.getResultList();
        }
    }

    public List<Reservation> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Reservation", Reservation.class).list();
        }
    }
}
