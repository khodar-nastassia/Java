package com.andersen.coworking_reservation.model;

public class Reservation {
    private int id;
    private String customerName;
    private int workplaceId;
    private String date;
    private String startTime;
    private String endTime;

    public Reservation(int id, String customerName, int workplaceId, String date, String startTime, String endTime) {
        this.id = id;
        this.customerName = customerName;
        this.workplaceId = workplaceId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public int getId() { return id; }
    public String getCustomerName() { return customerName; }
    public int getWorkplaceId() { return workplaceId; }
    public String getDate() { return date; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }

    public void setId(int id) { this.id = id; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setWorkplaceId(int workplaceId) { this.workplaceId = workplaceId; }
    public void setDate(String date) { this.date = date; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

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
