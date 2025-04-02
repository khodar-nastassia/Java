import java.util.ArrayList;
import java.util.List;

public class Data {

    private static ArrayList<Reservation> reservations = new ArrayList<>();
    private static ArrayList<WorkPlace> places = new ArrayList<>();

    public static void initializePlaces() {
        places.add(new WorkPlace(1,"open space by the window", 100.00));
        places.add(new WorkPlace(2,"open space by the window", 100.00));
        places.add(new WorkPlace(3,"open space by the bathroom", 50.00));
        places.add(new WorkPlace(4,"open space by the bathroom", 50.00));
        places.add(new WorkPlace(5,"open space by the cafe", 90.00));
        places.add(new WorkPlace(6,"open space by the cafe", 90.00));
        places.add(new WorkPlace(7,"private room", 200.00));
        places.add(new WorkPlace(8,"private room", 200.00));
    }

    public static ArrayList<WorkPlace> getPlaces() {
        return places;
    }

    public static void setUnavailablePlace(int id) {
        for(WorkPlace place: places){
            if (place.getId()==id){
                place.setAvailable(false);
            }
        }
    }

    public static void addWorkplace(WorkPlace place){
        places.add(place);
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public static void addReservation(Reservation res){
        reservations.add(res);
    }
}