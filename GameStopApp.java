import java.util.Scanner;
import java.util.ArrayList;

public class GameStopApp {
    // 1. Storage for the "Session"
    private static Customer currentUser = null;
    private static Cart currentCart = new Cart();
    private static OrderHistory history = new OrderHistory();
    private static Catalog storeCatalog = new Catalog();
    private static Scanner scanner = new Scanner(System.in);

    // 2. The "Security Brain" - Password Complexity
    public static boolean isValidPassword(String password) {
        if (password.length() < 6) return false;
        boolean hasDigit = false, hasUpper = false, hasSpecial = false;
        String specials = "@#$%&*";
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) hasDigit = true;
            if (Character.isUpperCase(c)) hasUpper = true;
            if (specials.contains(String.valueOf(c))) hasSpecial = true;
        }
        return hasDigit && hasUpper && hasSpecial;
    }

    public static void main(String[] args) {
        // Setup the GameStop Inventory
        storeCatalog.addProduct(new Product("PS5 Pro", "8K Console", 699.99, 699.99));
        storeCatalog.addProduct(new Product("Zelda: Echoes", "Action Adventure", 59.99, 49.99));
        storeCatalog.addProduct(new Product("Gengar Squishmallow", "Collectibles", 24.99, 19.99));

        // Creating one "Test Account" for quick debugging
        Customer testUser = new Customer("James123", "Gamer@1", "Color?", "Red", "1234123412341234");

        boolean running = true;
        System.out.println("--- Welcome to GameStop COS ---");

        while (running) {
            if (currentUser == null) {
                System.out.println("\n1. Create Account\n2. Log On\n3. Exit");
                int choice = getIntInput();

                if (choice == 1) {
                    System.out.println("Enter ID:");
                    String id = scanner.nextLine();
                    String pw = "";
                    while (true) {
                        System.out.println("Enter Password (6+ chars, 1 Upper, 1 Digit, 1 Special):");
                        pw = scanner.nextLine();
                        if (isValidPassword(pw)) break;
                        System.out.println("Invalid Password format!");
                    }
                    System.out.println("Security Question:");
                    String q = scanner.nextLine();
                    System.out.println("Answer:");
                    String a = scanner.nextLine();
                    System.out.println("Credit Card (16 digits):");
                    String cc = scanner.nextLine();

                    testUser = new Customer(id, pw, q, a, cc); // Store as our current test user
                    System.out.println("Account Created!");

                } else if (choice == 2) {
                    // Logic for Login
                    System.out.println("Enter ID:");
                    String id = scanner.nextLine();
                    System.out.println("Enter Password:");
                    String pw = scanner.nextLine();

                    if (testUser.getCustomerID().equals(id) && testUser.getPassword().equals(pw)) {
                        System.out.println("Security: " + testUser.getSecurityQuestion());
                        if (scanner.nextLine().equalsIgnoreCase(testUser.getSecurityAnswer())) {
                            currentUser = testUser;
                            System.out.println("Welcome, " + currentUser.getCustomerID() + "!");
                        } else {
                            System.out.println("Wrong answer. System Terminated.");
                            return;
                        }
                    } else {
                        System.out.println("Login Failed.");
                    }
                } else {
                    running = false;
                }
            } else {
                // LOGGED IN MENU
                System.out.println("\n--- PowerUp Rewards Menu ---");
                System.out.println("1. Browse Catalog\n2. View Cart\n3. Make Order\n4. View History\n5. Log Out");
                int choice = getIntInput();

                switch (choice) {
                    case 1:
                        storeCatalog.browseCatalog();
                        System.out.println("Enter item # to add to cart (or 0 to go back):");
                        int itemNum = getIntInput();
                        if (itemNum > 0) {
                            Product p = storeCatalog.getProduct(itemNum - 1);
                            if (p != null) {
                                currentCart.addItem(p, 1);
                                System.out.println("Added " + p.getName() + " to cart!");
                            }
                        }
                        break;
                    case 2:
                        currentCart.displayCart();
                        break;
                    case 3:
                        processCheckout();
                        break;
                    case 4:
                        history.viewCustomerOrders(currentUser.getCustomerID());
                        break;
                    case 5:
                        currentUser = null;
                        System.out.println("Logged out.");
                        break;
                }
            }
        }
    }

    // Helper to handle payment and delivery logic
    private static void processCheckout() {
        double subtotal = currentCart.calculateSubtotal();
        if (subtotal == 0) {
            System.out.println("Cart is empty!");
            return;
        }

        System.out.println("Delivery Method: 1. Mail (+$3.00) 2. Pickup (Free)");
        int delivery = getIntInput();
        double total = subtotal + (subtotal * 0.0825);
        if (delivery == 1) total += 3.00;

        System.out.printf("Total Charge: $%.2f. Confirm? (y/n)%n", total);
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            // Simulate Bank Auth
            String auth = "8842";
            Order newOrder = new Order(currentUser.getCustomerID(), total, auth);
            history.addOrder(newOrder);
            System.out.println("Order Confirmed! Auth Code: " + auth);
            currentCart = new Cart(); // Clear cart after success
        }
    }

    // Utility to prevent Scanner errors
    private static int getIntInput() {
        try {
            int val = Integer.parseInt(scanner.nextLine());
            return val;
        } catch (Exception e) {
            return -1;
        }
    }
}