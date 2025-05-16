package com.andersen.coworking_reservation.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppBeansConfig {
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
