import java.util.ArrayList;

public class Catalog {
    // 1. The "Dynamic Shelf" (The Database)
    private ArrayList<Product> products = new ArrayList<>();

    // 2. The "Stocking" Tool
    public void addProduct(Product p) { 
        products.add(p); 
    }

    // 3. The "Store Floor" Tool
    public void browseCatalog() {
        System.out.println("\n--- GameStop Product Catalog ---");
        for (int i = 0; i < products.size(); i++) {
            // Adding 1 to the index makes it "Human Friendly" (1, 2, 3 instead of 0, 1, 2)
            System.out.print((i + 1) + ". ");
            products.get(i).display();
        }
    }

    // 4. The "Grab Item" Tool (The Connector)
    // This allows the Manager to pick a specific item after the user types a number
    public Product getProduct(int index) {
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        }
        // Safety check: returns null if the user picks a number not in the list
        return null;
    }
}