package com.andersen.coworking_reservation;

import com.andersen.coworking_reservation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
