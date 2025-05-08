package com.andersen.coworking_reservation.service;

import com.andersen.coworking_reservation.Messages;
import com.andersen.coworking_reservation.dao.ReservationDao;
import com.andersen.coworking_reservation.dao.WorkplaceDAO;
import com.andersen.coworking_reservation.model.Reservation;
import com.andersen.coworking_reservation.model.Workplace;

import java.util.Scanner;

public class Action {
    Messages message;
    WorkplaceDAO workplaceDAO;
    Scanner scanner;
    ReservationDao reservationDao;

    public Action(Messages message, WorkplaceDAO workplaceDAO, Scanner scanner, ReservationDao reservationDao) {
        this.message = message;
        this.workplaceDAO = workplaceDAO;
        this.scanner = scanner;
        this.reservationDao = reservationDao;
    }

    public void adminAct(String choice) {
        switch (choice) {
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
            case "4" -> {
                System.out.println("Thank you!");
                return;
            }
            default -> message.warn();
        }
    }

    public void customerAct(String choice) {
        switch (choice) {
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
            case "5" -> {
                System.out.println("Thank you!");
                return;
            }
            default -> message.warn();
        }
    }
}
