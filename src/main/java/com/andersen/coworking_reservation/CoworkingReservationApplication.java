package com.andersen.coworking_reservation;

import com.andersen.coworking_reservation.config.AppConfig;
import com.andersen.coworking_reservation.dao.*;
import com.andersen.coworking_reservation.model.*;
import com.andersen.coworking_reservation.service.Action;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Scanner;


@EnableTransactionManagement

public class CoworkingReservationApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Scanner scanner = context.getBean(Scanner.class);
        Messages message = context.getBean(Messages.class);

        UserDAO userDAO = context.getBean(UserDAO.class);
        WorkplaceDAO workplaceDAO = context.getBean(WorkplaceDAO.class);
        ReservationDao reservationDao = context.getBean(ReservationDao.class);
        PlatformTransactionManager txManager = context.getBean(PlatformTransactionManager.class);
        Action action = context.getBean(Action.class);

        while (true) {
            TransactionStatus tx = txManager.getTransaction(new DefaultTransactionDefinition());
            try {
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
                        txManager.commit(tx);
                        continue;
                    }

                    System.out.println("Welcome, " + user.getName());


                    if (user.getRole().equals("admin")) {
                        message.chooseAdminAct();
                        String adminAct = scanner.nextLine();
                        action.adminAct(adminAct);
                    } else {
                        message.chooseCustomerAct();
                        String customerAct = scanner.nextLine();
                        action.customerAct(customerAct);
                    }
                } else if (choice.equals("2")) {
                    System.out.print("Choose Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Choose Email: ");
                    String email = scanner.nextLine();

                    if (userDAO.checkEmail(email)) {
                        System.out.println("An account already exists. Please login.");
                        txManager.commit(tx);
                        continue;
                    }
                    System.out.print("Role (admin/customer): ");
                    String role = scanner.nextLine().toLowerCase();

                    if (!role.equals("admin") && !role.equals("customer")) {
                        System.out.println("Invalid role. Please enter 'admin' or 'customer'.");
                        txManager.commit(tx);
                        continue;
                    }

                    User user = new User(username, email, role);

                    userDAO.register(user);
                    System.out.println("Registered successfully.");
                    System.out.println("Welcome, " + user.getName());

                    if (user.getRole().equals("admin")) {
                        message.chooseAdminAct();
                        String adminAct = scanner.nextLine();
                        action.adminAct(adminAct);
                    } else {
                        message.chooseCustomerAct();
                        String customerAct = scanner.nextLine();
                        action.customerAct(customerAct);
                    }


                } else {
                    txManager.commit(tx);
                    context.close();
                    return;
                }
                txManager.commit(tx);
            } catch (Exception e) {
                txManager.rollback(tx);
                e.printStackTrace();
            }
        }

    }
}
