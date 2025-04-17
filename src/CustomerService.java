import dto.Reservation;
import file.ObjectWriter;

import java.util.Scanner;

public class CustomerService {

    private static Scanner scanner = new Scanner(System.in);

    public static void viewMyReservations(){
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("\tYour reservations:");

        for (Reservation reservation : Data.getReservations()) {
            int res = 0;
            if (reservation.getCustomerName().equals(name)) {
                reservation.showInfo();
            }
        }
    }

    public static void cancelMyReservation(){
        while (true) {
            System.out.println("Current reservations:");
            viewMyReservations();
            System.out.print("Enter your reservation ID: ");
            String input = scanner.nextLine();
            try {
                int reservationId = Integer.parseInt(input);
                boolean removed = Data.getReservations().removeIf(reservation -> reservation.getId() == reservationId);
                if (removed) {
                    System.out.println("The reservation canceled.");
                    ObjectWriter.rewriteObjectsFile(Data.getReservations(), "src/file/dataReservation.txt");

                    break;
                } else {
                    System.out.println("Error: No reservation found with this ID. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }
}
