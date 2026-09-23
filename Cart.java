import java.util.HashMap;

public class Cart {
    // 1. The Data (The Ledger)
    private HashMap<Product, Integer> items = new HashMap<>();

    // 2. The "Add to Cart" Tool
    public void addItem(Product p, int quantity) {
        items.put(p, items.getOrDefault(p, 0) + quantity);
    }

    // 3. The "Math" Tool
    public double calculateSubtotal() {
        double subtotal = 0;
        for (Product p : items.keySet()) {
            subtotal += p.getSalesPrice() * items.get(p);
        }
        return subtotal;
    }

    // 4. The "Show the User" Tool (New Personalization!)
    public void displayCart() {
        System.out.println("\n--- Your GameStop Cart ---");
        for (Product p : items.keySet()) {
            // This assumes your Product class has a getName() method
            System.out.println(p.getName() + " x" + items.get(p) + " @ $" + p.getSalesPrice());
        }
        double sub = calculateSubtotal();
        System.out.println("Subtotal: $" + String.format("%.2f", sub));
    }
}