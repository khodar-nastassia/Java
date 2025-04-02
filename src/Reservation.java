public class Reservation {
    private int id;
    private String customerName;
    private int workplaceId;
    private String date;
    private String startTime;
    private String endTime;
    static int reservationCounter = 1;

    public Reservation(String customerName, int workplaceId, String date,String startTime,String endTime){
        this.id = reservationCounter++;
        this.customerName =  customerName;
        this.workplaceId = workplaceId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() { return id;}
    public int getWorkplaceId() { return workplaceId; }
    public String getCustomerName() { return customerName; }

    public void showInfo(){
        System.out.printf("Reservation: %d | Customer: %s | Workplace: %d | Date: %s | StartTime: %s, | EndTime: %s", id, customerName, workplaceId, date, startTime, endTime);
        System.out.println();
    }
}