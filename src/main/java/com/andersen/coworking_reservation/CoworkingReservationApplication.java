package com.andersen.coworking_reservation;

import com.andersen.coworking_reservation.dao.*;
import com.andersen.coworking_reservation.model.*;
import com.andersen.coworking_reservation.service.Action;



import java.util.Scanner;

public class CoworkingReservationApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        WorkplaceDAO workplaceDAO = new WorkplaceDAO();
        ReservationDao reservationDao = new ReservationDao();

        while (true) {
            try {
                Messages message = new Messages();
                message.chooseAction();
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    User user = userDAO.findByUserEmail(email);
                    if (user == null) {
                        System.out.println("User not found. Please register first.");
                        continue;
                    }else {
                        System.out.println(user.getName());
                    }
                    System.out.println("Welcome, " + user.getName());
                    if (user.getRole().equals("admin")) {
                        message.chooseAdminAct();
                        String adminAct = scanner.nextLine();
                        Action a = new Action(message, workplaceDAO, scanner, reservationDao);
                        a.adminAct(adminAct);
                    } else {
                        message.chooseCustomerAct();
                        String customerAct = scanner.nextLine();
                        Action a = new Action(message, workplaceDAO, scanner, reservationDao);
                        a.customerAct(customerAct);
                    }
                } else if (choice.equals("2")) {
                    System.out.print("Choose Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Choose Email: ");
                    String email = scanner.nextLine();
                    if (userDAO.checkEmail(email)) {
                        System.out.println("An account already exists. Please login.");
                        continue;
                    }
                    System.out.print("Role (admin/customer): ");
                    String role = scanner.nextLine().toLowerCase();

                    if (!role.equals("admin") && !role.equals("customer")) {
                        System.out.println("Invalid role. Please enter 'admin' or 'customer'.");
                        continue;
                    }
                    User user = new User(username, email, role);

                    userDAO.register(user);
                    System.out.println("Registered successfully.");
//                    User user = userDAO.findByUserEmail(email);
                    System.out.println("Welcome, " + user.getName());
                    if (user.getRole().equals("admin")) {
                        message.chooseAdminAct();
                        String adminAct = scanner.nextLine();
                        Action a = new Action(message, workplaceDAO, scanner, reservationDao);
                        a.adminAct(adminAct);
                    } else {
                        message.chooseCustomerAct();
                        String customerAct = scanner.nextLine();
                        Action a = new Action(message, workplaceDAO, scanner, reservationDao);
                        a.customerAct(customerAct);
                    }


                } else {
                    return;
                }
            } finally {

            }
        }

    }
}
