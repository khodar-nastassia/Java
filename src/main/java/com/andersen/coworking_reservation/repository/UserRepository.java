package com.andersen.coworking_reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.andersen.coworking_reservation.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByNameIgnoreCase(String name);
    boolean existsByEmail(String email);
}
