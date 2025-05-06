package com.andersen.coworking_reservation.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String role;

    public User(int id, String username, String email, String role) {
        this.id = id;
        this.name = username;
        this.email = email;
        this.role = role;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
}
