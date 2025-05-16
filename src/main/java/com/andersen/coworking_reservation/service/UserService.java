package com.andersen.coworking_reservation.service;

import com.andersen.coworking_reservation.model.User;

public interface UserService {
    User findByEmail(String email);
    void register(User user);
    boolean userExists(String email);
}
