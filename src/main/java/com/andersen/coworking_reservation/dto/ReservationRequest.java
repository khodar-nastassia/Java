package com.andersen.coworking_reservation.dto;

import lombok.Data;

@Data
public class ReservationRequest {
    private Long userId;
    private Long workplaceId;
    private String date;
    private String startTime;
    private String endTime;
}
