import dto.Reservation;
import dto.Workplace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {

    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static Map<Integer, Workplace> workplaces = new HashMap<>();

    //private static ArrayList<Admin> admins = new ArrayList<>();

    public static Map<Integer, Workplace> getWorkplaces(){return workplaces;}
    public static void setWorkplaces(HashMap<Integer, Workplace> loadedWorkplaces){
        workplaces = loadedWorkplaces;
    }

    public static void showWorkplaces() {
        if (workplaces.isEmpty()) {
            System.out.println("No workplaces available.");
        } else {
            for (Workplace wp : workplaces.values()) {
                wp.showInfo();
            }
        }
    }

    public static void setReservations(ArrayList<Reservation> loadedReservations) { reservations = loadedReservations; }
    public static ArrayList<Reservation> getReservations() { return reservations; }



    public static void setUnavailablePlace(int id) {
        Workplace workplace = workplaces.get(id);
        if (workplace != null) {
            workplace.setAvailable(false);
        } else {
            System.out.println("No workplace found with ID " + id);
        }
    }

    public static void addWorkplace(Workplace workplace){

        workplaces.put(workplace.getId(), workplace);
        //saveWorkplaces();
    }

    public static void addReservation(Reservation res){
        reservations.add(res);
    }
    }