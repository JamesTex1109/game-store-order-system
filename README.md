# Game Store Order System

A Java console app that simulates a video game store's customer order system. You can create an account, log in with a password and security question, browse the catalog, add items to your cart, check out with tax and delivery options, and view your order history. I designed it from a UML class diagram first and then built the classes to match.

## Features
- **Account creation** with password rules: 6+ characters, 1 uppercase letter, 1 digit, 1 special character (`@#$%&*`)
- **Two-step login:** password, then a security question
- **Catalog browsing** with regular and sale prices
- **Shopping cart** that tracks quantities and the subtotal
- **Checkout** with 8.25% sales tax and a choice of mail delivery (+$3.00) or free pickup
- **Order history** with date, total, and authorization code

## Class Design

![UML class diagram](uml_diagram.png)

| Class | Role |
|---|---|
| `GameStopApp` | Main controller: menus, session, checkout |
| `Customer` | Account credentials and payment info |
| `Catalog` | List of available products |
| `Product` | Name, description, and pricing |
| `Cart` | Selected products and quantities (`HashMap<Product, Integer>`) |
| `Order` | A completed transaction |
| `OrderHistory` | Stores past orders |

## Run It
Requires Java 8+.

```bash
javac *.java
java GameStopApp
```

**Test account:** ID `James123`, password `Gamer@1`, security answer `Red`

## Notes
- This is a simulation. Passwords and card numbers are stored in plain text and bank authorization is mocked. A real system would hash credentials and use a payment processor.
- Data only lasts for one session, and one account is stored at a time.
