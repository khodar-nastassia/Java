package dto;

import java.io.Serializable;

public class Workplace implements Serializable  {

    private static int idCounter;
    private int id;
    private String type;
    private double price;
    private boolean isAvailable;

    public Workplace(String type, double price){
        this.id = idCounter++;
        this.type = type;
        this.price = price;
        this.isAvailable = true;
    }
    public int getId() { return id; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    public void showInfo(){
        System.out.printf("ID: %d | Type: %s | Price: %f | Available: %s", id, type, price, (isAvailable ? "Yes" : "No"));
        System.out.println();
    }
}