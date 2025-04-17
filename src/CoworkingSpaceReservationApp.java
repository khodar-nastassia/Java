import dto.*;
import file.ObjectReader;

import java.util.*;

public class CoworkingSpaceReservationApp {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String dataWorkplacePath = "src/file/dataWorkplace.txt";
        String dataReservationPath = "src/file/dataReservation.txt";

        Optional<Object> workplaceResult = ObjectReader.readObjectsFromFile(dataWorkplacePath, Workplace.class);
        Optional<Object> reservationResult = ObjectReader.readObjectsFromFile(dataReservationPath, Reservation.class);


        workplaceResult.ifPresent(obj -> {
            if (obj instanceof HashMap<?, ?> map) {
                HashMap<Integer, Workplace> loadedWorkplaces = (HashMap<Integer, Workplace>) map;
                Data.setWorkplaces(loadedWorkplaces);
            }
        });

        reservationResult.ifPresent(obj -> {
            if (obj instanceof List<?> list) {
                ArrayList<Reservation> loadedReservations = (ArrayList<Reservation>) list;
                Data.setReservations(loadedReservations);
            }
        });

        while (true) {
            try {
                Messages message = new Messages();
                message.chooseUser();
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1" -> {
                        message.chooseAdminAct();
                        String adminAct = scanner.nextLine();
                        switch (adminAct) {
                            case "1" -> AdminService.addWorkplace();
                            case "2" -> AdminService.removeWorkplace();
                            case "3" -> AdminService.viewAllReservations();
                            default -> message.warn();
                        }
                    }
                    case "2" -> {
                        message.chooseCustomerAct();
                        String customerAct = scanner.nextLine();
                        switch (customerAct) {
                            case "1" -> UserService.browseAvailablePlaces();
                            case "2" -> UserService.makeReservation();
                            case "3" -> CustomerService.viewMyReservations();
                            case "4" -> CustomerService.cancelMyReservation();
                            default -> message.warn();
                        }
                    }
                    case "3" -> {
                        System.out.println("Thank you!");
                        return;
                    }
                    default -> message.warn();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }
    }
}