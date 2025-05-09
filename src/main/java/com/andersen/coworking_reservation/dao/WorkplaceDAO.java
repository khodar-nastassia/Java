package com.andersen.coworking_reservation.dao;
import com.andersen.coworking_reservation.db.HibernateUtil;
import com.andersen.coworking_reservation.model.Workplace;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;
public class WorkplaceDAO {
    public List<Workplace> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Workplace", Workplace.class).list();
        }
    }

    public void add(String type, Double price) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Workplace workplace = new Workplace(type, price, true);
            session.save(workplace);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Workplace workplace = session.get(Workplace.class, id);
            if (workplace != null) {
                session.delete(workplace);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void updateIsAvailable(int id, boolean isAvailable) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Workplace workplace = session.get(Workplace.class, id);
            if (workplace != null) {
                workplace.setIsAvailable(isAvailable);
                session.update(workplace);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Workplace> getAvailableWorkplaces() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Workplace> query = session.createQuery(
                    "FROM Workplace WHERE isAvailable = true", Workplace.class);
            return query.list();
        }
    }
}
