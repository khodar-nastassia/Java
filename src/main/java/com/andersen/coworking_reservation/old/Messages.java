public class Messages {
    String userMessage = """
        \tWelcome to Coworking Space Reservation System!
        1. Admin login
        2. User Login
        Enter choice:""";

    String adminMessage = """
        \tWelcome to Admin Area!
        1. Add a new coworking space
        2. Remove a coworking space
        3. View all reservations
        4. Exit
        Enter choice:""";

    String customerMessage = """
        \tWelcome to Customer Area!
        1. Browse available places
        2. Make a reservation
        3. View my reservations
        4. Cancel a reservation
        5.Exit
        Enter choice:""";

    String warningMessage = "Invalid choice!";

    public void chooseUser(){System.out.println(userMessage);}
    public void chooseAdminAct(){System.out.println(adminMessage);}
    public void chooseCustomerAct(){System.out.println(customerMessage);}
    public void warn(){System.out.println(warningMessage);}
}