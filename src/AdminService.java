import dto.Reservation;
import dto.Workplace;
import file.ObjectWriter;

import java.util.Scanner;

public class AdminService {

    private static Scanner scanner = new Scanner(System.in);

    public static void addWorkplace(){
        String type;
        double price;

        while (true){
            System.out.print("Enter a type of workplace: ");
            String inputType = scanner.nextLine();
            try{
                if (inputType.isEmpty()) {
                    throw new MyException("Error: Type cannot be empty.");
                } else {
                    type = inputType;
                    break;
                }
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true){
            System.out.print("Enter price: ");
            String priceIn = scanner.nextLine();
            try {
                price = Double.parseDouble(priceIn);
                if (price < 0) {
                    System.out.println("Error. Price cannot be negative.");
                } else {
                    break;
                }
            } catch(NumberFormatException e) {
                System.out.println("Error: Enter a valid number.");
            }
        }

        Workplace workplace = new Workplace(type, price);
        Data.addWorkplace(workplace);
        ObjectWriter.writeObjectToFile(workplace, "src/file/dataWorkplace.txt");
        System.out.println("The workplace added");
    }

    public static void removeWorkplace(){
        while (true){
            if(Data.getWorkplaces().isEmpty()){
                System.out.println("No workplaces to remove.");
                return;
            }
            System.out.println("Current workplaces:");
            for (Workplace workplace : Data.getWorkplaces()) {
                workplace.showInfo();
            }
            System.out.print("Enter workplace ID to remove: ");
            String input = scanner.nextLine();
            try{
                int workplaceId = Integer.parseInt(input);
                boolean removed = Data.getWorkplaces().removeIf(workplace->workplace.getId()==workplaceId);
                if (removed) {
                    System.out.println("The workplace removed.");
                    ObjectWriter.rewriteObjectsFile(Data.getWorkplaces(), "src/file/dataWorkplace.txt");
                    break;
                } else {
                    System.out.println("Error: No workplace found with this ID. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
            }
        }
    }

    public static void viewAllReservations(){
        System.out.println("\tAll Reservations:");
        for (Reservation reservation : Data.getReservations()) {
            reservation.showInfo();
        }
    }

}