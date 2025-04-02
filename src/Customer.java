import java.util.Scanner;

class Customer extends User{
    private static Scanner scanner = new Scanner(System.in);

    public Customer(String name){
        super(name);
    }

    public static void viewMyReservations(){
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("\tYour reservations:");
        for (Reservation reservation : Data.getReservations()) {
            if (reservation.getCustomerName().equals(name)) {
                reservation.showInfo();
            }
        }
    }

    public static void cancelMyReservation(){
        System.out.print("Enter your reservation ID: ");
        int id = scanner.nextInt();
        for (Reservation reservation : Data.getReservations()) {
            if (reservation.getId()==id) {
                Data.getReservations().remove(id-1);
            }
        }
        System.out.println("Reservation canceled");
    }
}