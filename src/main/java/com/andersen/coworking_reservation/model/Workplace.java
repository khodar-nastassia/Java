package com.andersen.coworking_reservation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "workplaces")
@Setter
@Getter
public class Workplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    private double price;

    @Column(name = "is_available")
    private boolean isAvailable;
    public Workplace(){}

    public Workplace(String type,double price) {

        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }
    public void setIsAvailable(boolean available) {
        this.isAvailable = available;
    }

}
