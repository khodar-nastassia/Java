package dto;

import java.io.Serializable;

public class Reservation implements Serializable {

    private int id;
    private String customerName;
    private int workplaceId;
    private String date;
    private String startTime;
    private String endTime;
    private static int reservationCounter = 1;

    public Reservation(String customerName, int workplaceId, String date,String startTime,String endTime){
        if (customerName == null || customerName.isBlank())
            throw new IllegalArgumentException("Customer name cannot be null or blank");
        if (workplaceId <= 0)
            throw new IllegalArgumentException("Workplace ID must be positive");
        if (date == null || date.isBlank())
            throw new IllegalArgumentException("Date cannot be null or blank");
        if (startTime == null || endTime == null)
            throw new IllegalArgumentException("Time values cannot be null");
        this.id = reservationCounter++;
        this.customerName =  customerName;
        this.workplaceId = workplaceId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() { return id;}
    public int getWorkplaceId() { return workplaceId; }
    public String getCustomerName() { return customerName; }

    public void showInfo(){
        System.out.printf("Reservation: %d | Customer: %s | Workplace: %d | Date: %s | StartTime: %s, | EndTime: %s", id, customerName, workplaceId, date, startTime, endTime);
        System.out.println();
    }
}