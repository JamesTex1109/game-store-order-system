import java.util.ArrayList;

public class OrderHistory {
    // 1. The "Filing Cabinet" (A list of past Order objects)
    private ArrayList<Order> allOrders = new ArrayList<>();

    // 2. The "File Away" Tool
    // Requirement: System stores the order after successful bank auth
    public void addOrder(Order newOrder) {
        allOrders.add(newOrder);
    }

    // 3. The "Search & Display" Tool
    // Requirement: View Order History Main Sequence
    public void viewCustomerOrders(String currentID) {
        System.out.println("\n--- Order History for User: " + currentID + " ---");
        boolean found = false;

        for (Order o : allOrders) {
            // In a more complex system, we'd filter by ID here.
            // For this simulation, we'll display the orders stored in this session.
            o.displayOrderDetails();
            found = true;
        }

        if (!found) {
            System.out.println("No past orders found for this account.");
        }
    }
}