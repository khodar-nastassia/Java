import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private static Scanner scanner = new Scanner(System.in);

    public User(String name){
        this.name = name;
    }

    public static void browseAvailablePlaces(){
        System.out.println("\tAvailable Coworking Spaces:");
            for (WorkPlace place : Data.getPlaces()) {
                if (place.isAvailable()) {
                    place.showInfo();
                }
            }
    }

    public static void makeReservation() {
        browseAvailablePlaces();
        System.out.print("Enter workplace ID to book: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter start time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:MM): ");
        String endTime = scanner.nextLine();

        Reservation res = new Reservation(name, id,  date, startTime, endTime);
        Data.addReservation(res);
        System.out.println("Reservation successful");
        Data.setUnavailablePlace(id);
    }




}





//
//    }
//
//    void cancelReservation(){
//
//    }
//    void selectWS(){
//
//    }
//    void Enter(){}
//}
