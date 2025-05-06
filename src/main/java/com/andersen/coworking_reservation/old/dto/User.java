package dto;

public class User {

    private String name;
    private int userId;
    static int userIdCounter = 1;

    public User(String name){
        this.name = name;
        this.userId = userIdCounter++;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
}