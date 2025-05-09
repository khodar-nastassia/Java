package com.andersen.coworking_reservation;

import com.andersen.coworking_reservation.db.HibernateUtil;
import com.andersen.coworking_reservation.model.User;
import org.hibernate.Session;

public class Test {
    public static void main1(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        User user = new User("tom2", "tom2@", "customer");
        session.persist(user);
        String email = "alex@";
        User alex = session.createQuery(
                        "FROM User WHERE email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult();
        System.out.println(alex.getName());
        session.getTransaction().commit();
        session.close();
        HibernateUtil.close();

    }
}
