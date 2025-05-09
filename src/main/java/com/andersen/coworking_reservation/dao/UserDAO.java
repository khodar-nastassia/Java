package com.andersen.coworking_reservation.dao;
import com.andersen.coworking_reservation.db.HibernateUtil;
import com.andersen.coworking_reservation.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class UserDAO {
    public User findByUserEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                            "FROM User WHERE email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }

    public void register(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    public boolean checkEmail(String email){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                    "SELECT count(u.id) FROM User u WHERE u.email = :email", Long.class
            );
            query.setParameter("email", email);
            Long count = query.uniqueResult();
            return count != null && count > 0;
        }
    }
}
