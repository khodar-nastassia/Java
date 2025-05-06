package com.andersen.coworking_reservation;

import com.andersen.coworking_reservation.dao.*;
import com.andersen.coworking_reservation.model.*;

import java.util.List;
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

                switch (choice) {
                    case "1" -> {
                        System.out.print("Username: ");
                        String name = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        User user = userDAO.findByUserEmail(name);
                        if (user == null) {
                            System.out.println("Login failed.");
                            return;
                        }
                        System.out.println("Welcome, " + user.getName());

                        if (user.getRole().equals("admin")) {
                            message.chooseAdminAct();
                            String adminAct = scanner.nextLine();
                            switch (adminAct) {
                                case "1" -> {
                                    String type = message.getType();
                                    Double price = message.getPrice();
                                    workplaceDAO.add(type, price);
                                    System.out.println("The workplace added");
                                }
                                case "2" -> {
                                    System.out.println("Current workplaces:");
                                    for (Workplace workplace : workplaceDAO.getAll()) {
                                        System.out.println(workplace.getId());
                                    }
                                    System.out.print("Choose workplace ID to remove: ");
                                    int input = scanner.nextInt();
                                    workplaceDAO.delete(input);
                                }
                                case "3" -> {
                                    for (Reservation r : reservationDao.getAll()) {
                                        r.toString();
                                    }
                                }
                                default -> message.warn();
                            }
                        } else {
                            message.chooseCustomerAct();
                            String customerAct = scanner.nextLine();
                            switch (customerAct) {
                                case "1" -> {
                                    for (Workplace wp : workplaceDAO.getAvailableWorkplaces()) {
                                        System.out.println(wp.getId());
                                    }
                                }

                                case "2" -> {
                                    for (Workplace wp : workplaceDAO.getAvailableWorkplaces()) {
                                        System.out.println(wp.getId());
                                    }
                                    System.out.print("Choose a workplace ID to book: ");
                                    int input = scanner.nextInt();
                                    System.out.print("Enter your name: ");
                                    String customerName = scanner.nextLine();
                                    System.out.print("Enter date (YYYY-MM-DD): ");
                                    String date = scanner.nextLine();
                                    System.out.print("Enter start time (HH:MM): ");
                                    String startTime = scanner.nextLine();
                                    System.out.print("Enter end time (HH:MM): ");
                                    String endTime = scanner.nextLine();

                                    reservationDao.reserve(customerName, input, date, startTime, endTime);
                                }
                                case "3" -> {
                                    System.out.print("Enter your name: ");
                                    String customerName = scanner.nextLine();
                                    System.out.println("\tYour reservations:");
                                    for (Reservation r : reservationDao.getByCustomerName(customerName)) {
                                        r.toString();
                                    }
                                }
                                case "4" -> {
                                    System.out.print("Enter your reservation ID: ");
                                    int input = scanner.nextInt();
                                    reservationDao.cancel(input);
                                }
                                default -> message.warn();
                            }
                        }

                    }

                }
            }
        }
    }
}
