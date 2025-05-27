package com.andersen.coworking_reservation.service;

import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Optional<User> findByNameIgnoreCase(String username) {
        return userRepository.findByNameIgnoreCase(username);
    }
}
