//import dto.*;
//import file.ObjectReader;
//
//import java.util.*;
//
//public class CoworkingSpaceReservationApp {
//
//    private static Scanner scanner = new Scanner(System.in);
//
//    public static void mainOLD(String[] args) {
//
//        String dataWorkplacePath = "src/file/dataWorkplace.txt";
//        String dataReservationPath = "src/file/dataReservation.txt";
//
//        HashMap<Integer, Workplace> loadedWorkplaces = (HashMap<Integer, Workplace>)ObjectReader.readObjectsFromFile(dataWorkplacePath, Workplace.class);
//        ArrayList<Reservation> loadedReservations = (ArrayList<Reservation>)ObjectReader.readObjectsFromFile(dataReservationPath, Reservation.class);
//
//        Data.setWorkplaces(loadedWorkplaces);
//        Data.setReservations(loadedReservations);
//
//        while (true) {
//            try {
//                Messages message = new Messages();
//                message.chooseUser();
//                String choice = scanner.nextLine();
//
//                switch (choice) {
//                    case "1" -> {
//                        message.chooseAdminAct();
//                        String adminAct = scanner.nextLine();
//                        switch (adminAct) {
//                            case "1" -> AdminService.addWorkplace();
//                            case "2" -> AdminService.removeWorkplace();
//                            case "3" -> AdminService.viewAllReservations();
//                            default -> message.warn();
//                        }
//                    }
//                    case "2" -> {
//                        message.chooseCustomerAct();
//                        String customerAct = scanner.nextLine();
//                        switch (customerAct) {
//                            case "1" -> UserService.browseAvailablePlaces();
//                            case "2" -> UserService.makeReservation();
//                            case "3" -> CustomerService.viewMyReservations();
//                            case "4" -> CustomerService.cancelMyReservation();
//                            default -> message.warn();
//                        }
//                    }
//                    case "3" -> {
//                        System.out.println("Thank you!");
//                        return;
//                    }
//                    default -> message.warn();
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//
//            }
//        }
//    }
//}