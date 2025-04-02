import java.util.*;

public class CoworkingSpaceReservationApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            Messages message = new Messages();
            message.chooseUser();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    message.chooseAdminAct();
                    int AdminAct = scanner.nextInt();
                    scanner.nextLine();
                    switch (AdminAct) {
                        case 1 -> Admin.addWorkplace();
                        case 2 -> Admin.removeWorkplace();
                        case 3 -> Admin.viewAllReservations();
                        default -> message.warn();
                    }
                }
                case 2 -> {
                    message.chooseCustomerAct();
                    int CustomerAct = scanner.nextInt();
                    scanner.nextLine();
                    switch (CustomerAct) {
                        case 1 -> Customer.browseAvailablePlaces();
                        case 2 -> Customer.makeReservation();
                        case 3 -> Customer.viewMyReservations();
                        case 4 -> Customer.cancelMyReservation();
                        default -> message.warn();
                    }
                }
                case 3 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> message.warn();
            }
        }

    }

}