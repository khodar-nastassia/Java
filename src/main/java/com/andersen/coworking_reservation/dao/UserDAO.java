package com.andersen.coworking_reservation.dao;

import com.andersen.coworking_reservation.model.User;

public interface UserDAO {
    User findByUserEmail(String email);
    void register(User user);
    boolean checkEmail(String email);
}
