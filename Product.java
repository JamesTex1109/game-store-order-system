public class Product {
    // 1. The Attributes (The "Identity" of the Item)
    private String name;
    private String description;
    private double regularPrice;
    private double salesPrice;

    // 2. The Constructor (How the item is "Born")
    public Product(String name, String desc, double reg, double sale) {
        this.name = name;
        this.description = desc;
        this.regularPrice = reg;
        this.salesPrice = sale;
    }

    // 3. The "Accessors" (How other classes see this data)
    // This allows the Cart to display the specific title
    public String getName() { 
        return name; 
    }

    // This allows the Cart to calculate the math for the subtotal
    public double getSalesPrice() { 
        return salesPrice; 
    }

    // 4. The "Show" Tool
    public void display() {
        System.out.println(name + ": " + description);
        // Using printf to make the money look professional (2 decimal places)
        System.out.printf("Reg: $%.2f | Sale: $%.2f%n", regularPrice, salesPrice);
    }
}