package com.andersen.coworking_reservation.service;

import com.andersen.coworking_reservation.Messages;
import com.andersen.coworking_reservation.dao.ReservationDao;
import com.andersen.coworking_reservation.dao.WorkplaceDAOImpl;
import com.andersen.coworking_reservation.model.Reservation;
import com.andersen.coworking_reservation.model.Workplace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
//@Component
public class Action {
    @Autowired
    private final Messages message;
    @Autowired
    private final WorkplaceDAOImpl workplaceDAO;
    @Autowired
    private final Scanner scanner;
    @Autowired
    private final ReservationDao reservationDao;

    @Autowired
    public Action(Messages message,
                  WorkplaceDAOImpl workplaceDAO,
                  Scanner scanner,
                  ReservationDao reservationDao) {
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
                Workplace workplace = new Workplace(type, price);
                workplaceDAO.add(workplace);
                System.out.println("The workplace added");
            }
            case "2" -> {
                System.out.println("Current workplaces:");
                for (Workplace workplace : workplaceDAO.getAll()) {
                    System.out.println("ID: " + workplace.getId());
                }
                System.out.print("Choose workplace ID to remove: ");
                int input = scanner.nextInt();
                scanner.nextLine();
                workplaceDAO.delete(input);
            }
            case "3" -> {
                List<Reservation> reservations = reservationDao.getAll();
                for (Reservation r : reservations) {
                    System.out.println(r);
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
                    System.out.println("ID: " + wp.getId());
                }
            }
            case "2" -> {
                for (Workplace wp : workplaceDAO.getAvailableWorkplaces()) {
                    System.out.println("ID: " + wp.getId());
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

                Reservation reservation = new Reservation(customerName, input, date, startTime, endTime);
                reservationDao.reserve(reservation);
            }
            case "3" -> {
                System.out.print("Enter your name: ");
                String customerName = scanner.nextLine();
                System.out.println("\tYour reservations:");
                for (Reservation r : reservationDao.getByCustomerName(customerName)) {
                    System.out.println(r);
                }
            }
            case "4" -> {
                System.out.print("Enter your reservation ID: ");
                int input = scanner.nextInt();
                reservationDao.cancel(input);
                System.out.println("Reservation cancelled.");
            }
            case "5" -> {
                System.out.println("Thank you!");
                return;
            }
            default -> message.warn();
        }
    }
}
