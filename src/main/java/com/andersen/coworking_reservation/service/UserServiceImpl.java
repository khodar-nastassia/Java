package com.andersen.coworking_reservation.service;

import com.andersen.coworking_reservation.dao.UserDAO;
import com.andersen.coworking_reservation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDAO = userDao;
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByUserEmail(email);
    }

    @Override
    public void register(User user) {
        userDAO.register(user);
    }

    @Override
    public boolean userExists(String email) {
        return userDAO.checkEmail(email);
    }
}
