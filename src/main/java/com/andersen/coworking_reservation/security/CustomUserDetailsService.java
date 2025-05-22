package com.andersen.coworking_reservation.security;
import com.andersen.coworking_reservation.model.User;
import com.andersen.coworking_reservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByNameIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: "));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getName())
                .password(user.getEmail())
                .roles(user.getRole())
                .build();
    }
}
