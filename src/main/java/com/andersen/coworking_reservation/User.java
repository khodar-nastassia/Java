package com.andersen.coworking_reservation;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usersTEST111")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
}