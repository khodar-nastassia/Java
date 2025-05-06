package com.andersen.coworking_reservation;

import com.andersen.coworking_reservation.model.Workplace;

import java.util.Scanner;

public class Messages {
    private Scanner scanner = new Scanner(System.in);
    String welcomeMessage = """
        \tWelcome to Coworking Space Reservation System!
        1. Login
        2. Register
        3. Exit
        Enter choice:""";

    String adminMessage = """
        \tWelcome to Admin Area!
        1. Add a new coworking space
        2. Remove a coworking space
        3. View all reservations
        Enter choice:""";

    String customerMessage = """
        \tWelcome to Customer Area!
        1. Browse available places
        2. Make a reservation
        3. View my reservations
        4. Cancel a reservation
        Enter choice:""";

    String warningMessage = "Invalid choice!";

    public void chooseAction(){System.out.println(welcomeMessage);}
    public void chooseAdminAct(){System.out.println(adminMessage);}
    public void chooseCustomerAct(){System.out.println(customerMessage);}
    public void warn(){System.out.println(warningMessage);}

    public String getType() {
        String type;
        while (true) {
            System.out.print("Enter a type of workplace: ");
            String inputType = scanner.nextLine();
            try {
                if (inputType.isEmpty()) {
                    throw new MyException("Error: Type cannot be empty.");
                } else {
                    type = inputType;
                    return type;
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public Double getPrice() {
        double price;
        while (true){
            System.out.print("Enter price: ");
            String priceIn = scanner.nextLine();
            try {
                price = Double.parseDouble(priceIn);
                if (price < 0) {
                    System.out.println("Error. Price cannot be negative.");
                } else {
                    return price;
                }
            } catch(NumberFormatException e) {
                System.out.println("Error: Enter a valid number.");
            }
        }
    }

}
