import java.util.Date;

public class Order {
    private Date orderDate;
    private String customerID;
    private double total;
    private String authorizationNumber;

    // The Constructor: This "records" the sale
    public Order(String id, double total, String auth) {
        this.orderDate = new Date(); // Automatically grabs the current time
        this.customerID = id;
        this.total = total;
        this.authorizationNumber = auth;
    }

    // The Display: For the "View Order History" use case
    public void displayOrderDetails() {
        System.out.print("Date: " + orderDate);
        System.out.printf(" | Total: $%.2f", total);
        System.out.println(" | Auth: " + authorizationNumber);
        System.out.println("------------------------------------------------");
    }
}