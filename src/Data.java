import dto.Admin;
import dto.Reservation;
import dto.Workplace;

import java.util.ArrayList;

public class Data {

    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static ArrayList<Workplace> workplaces = new ArrayList<>();
    //private static ArrayList<Admin> admins = new ArrayList<>();


    public static void setWorkplaces(ArrayList<Workplace> loadedWorkplaces){
        workplaces = loadedWorkplaces;
    }
    public static ArrayList<Workplace> getWorkplaces() { return workplaces; }

    public static void setReservations(ArrayList<Reservation> loadedReservations) { reservations = loadedReservations; }
    public static ArrayList<Reservation> getReservations() { return reservations; }



    public static void setUnavailablePlace(int id) {
        for(Workplace place: workplaces){
            if (place.getId()==id){
                place.setAvailable(false);
            }
        }
    }

    public static void addWorkplace(Workplace workplace){
        workplaces.add(workplace);
    }

    public static void addReservation(Reservation res){
        reservations.add(res);
    }




    }
