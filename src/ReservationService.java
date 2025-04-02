import java.util.ArrayList;

interface ReservationService {
    void makeReservation(String customerName, int workplaceId, String date, String startTime, String endTime);
    void cancelReservation(int reservationId);
    ArrayList<Reservation> getReservationsByCustomer(String customerName);
}
