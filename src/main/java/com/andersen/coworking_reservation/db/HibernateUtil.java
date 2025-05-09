package com.andersen.coworking_reservation.db;
import com.andersen.coworking_reservation.model.Reservation;
import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.model.Workplace;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.File;


public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration().configure();


            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Workplace.class);
            configuration.addAnnotatedClass(Reservation.class);

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void close() {
        getSessionFactory().close();
    }
}
