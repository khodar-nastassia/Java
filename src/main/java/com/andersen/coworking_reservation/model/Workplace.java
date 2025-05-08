package com.andersen.coworking_reservation.model;

public class Workplace {
    private int id;
    private String type;
    private double price;
    private boolean isAvailable;

    public Workplace(int id, String type,double price, boolean isAvailable) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.isAvailable = isAvailable;
    }
    public int getId() { return id; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean getIsAvailable() { return isAvailable; }

    public void setId(int id) { this.id = id; }
    public void setType(String type) { this.type = type; }
    public void setPrice(double price) { this.price = price; }
    public void setIsAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }
}
