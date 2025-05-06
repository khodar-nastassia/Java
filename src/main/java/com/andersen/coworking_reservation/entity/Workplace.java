package com.andersen.coworking_reservation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "workplaces")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private double price;
    private boolean isAvailable;
}
