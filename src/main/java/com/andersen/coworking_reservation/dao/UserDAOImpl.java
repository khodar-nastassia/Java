package com.andersen.coworking_reservation.dao;

import com.andersen.coworking_reservation.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User findByUserEmail(String email) {
        return getSession()
                .createQuery("FROM User WHERE email = :email", User.class)
                .setParameter("email", email)
                .uniqueResult();
    }
    @Override
    public void register(User user) {
        getSession().persist(user);
    }

    @Override
    public boolean checkEmail(String email){
        Query<Long> query = getSession().createQuery(
                "SELECT count(u.id) FROM User u WHERE u.email = :email", Long.class);
        query.setParameter("email", email);
        Long count = query.uniqueResult();
        return count != null && count > 0;
    }
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
