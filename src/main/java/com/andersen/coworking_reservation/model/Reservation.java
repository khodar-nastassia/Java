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
@Table(name = "reservations")
@Setter
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "workplace_id")
    private int workplaceId;
    private String date;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;

    public Reservation() {
    }

    public Reservation(String customerName, int workplaceId, String date, String startTime, String endTime) {

        this.customerName = customerName;
        this.workplaceId = workplaceId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", workplaceId=" + workplaceId +
                ", date='" + date + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
