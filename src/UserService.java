import dto.Reservation;
import dto.Workplace;
import java.util.Optional;
import file.ObjectWriter;

import java.util.Scanner;

public class UserService {

    private static Scanner scanner = new Scanner(System.in);

    public static void browseAvailablePlaces(){
        System.out.println("\tAvailable Coworking Spaces:");
        for (Workplace place : Data.getWorkplaces()) {
            if (place.isAvailable()) {
                place.showInfo();
            }
        }
    }

    public static void makeReservation() {
        browseAvailablePlaces();
        int workplaceId;
        String name;
        String date;
        String startTime;
        String endTime;

        while (true){
            System.out.print("Enter workplace ID to book: ");
            String input = scanner.nextLine();
            try{
                workplaceId = Integer.parseInt(input);
                int finalWorkplaceId = workplaceId;
                Optional<Workplace> workplace = Data.getWorkplaces().stream()
                        .filter(w -> w.getId() == finalWorkplaceId)
                        .findFirst();

                if (workplace.isPresent()) {
                    break;
                } else {
                    System.out.println("Error: No workplace found with this ID. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }

        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        date = scanner.nextLine();
        System.out.print("Enter start time (HH:MM): ");
        startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:MM): ");
        endTime = scanner.nextLine();

        Reservation res = new Reservation(name, workplaceId,  date, startTime, endTime);
        Data.addReservation(res);
        ObjectWriter.writeObjectToFile(res, "src/file/dataReservation.txt");
        System.out.println("Reservation successful");
        Data.setUnavailablePlace(workplaceId);
        ObjectWriter.rewriteObjectsFile(Data.getWorkplaces(),"src/file/dataWorkplace.txt");
    }

    public static void viewAllWorkplaces(){
        for (Workplace workplace : Data.getWorkplaces()) {
            workplace.showInfo();
        }
    }
}
