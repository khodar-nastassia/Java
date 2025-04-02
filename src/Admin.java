import java.util.Scanner;

class Admin extends User{
    private static Scanner scanner = new Scanner(System.in);

    public Admin(String name){
        super(name);
    }

    public static void addWorkplace(){
        System.out.print("Enter workplace ID: ");
        int workplaceId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter a type of workplace: ");
        String type = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        WorkPlace workplace = new WorkPlace(workplaceId, type, price);
        Data.addWorkplace(workplace);
        System.out.println("The workplace added");

    }

    public static void removeWorkplace(){
        System.out.print("Enter workplace ID: ");
        int workplaceId = scanner.nextInt();
        scanner.nextLine();
        Data.getPlaces().remove(workplaceId-1);
        System.out.println("the workplace removed");
    }

    public static void viewAllReservations(){
        System.out.println("\tAll Reservations:");
        for (Reservation reservation : Data.getReservations()) {
            reservation.showInfo();
        }
    }
}