public class Customer {
    // 1. The Secure Attributes (The Private Vault)
    private String customerID;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private String creditCardNumber;

    // 2. The Constructor (Account Creation)
    public Customer(String id, String pw, String q, String a, String cc) {
        this.customerID = id;
        this.password = pw;
        this.securityQuestion = q;
        this.securityAnswer = a;
        this.creditCardNumber = cc;
    }

    // 3. The "Getters" (Reading the Data)
    public String getCustomerID() { return customerID; }
    public String getPassword() { return password; }
    public String getSecurityQuestion() { return securityQuestion; }
    public String getSecurityAnswer() { return securityAnswer; }
    public String getCreditCardNumber() { return creditCardNumber; }

    // 4. The "Setter" (The Alternative Sequence Fix)
    // Requirement: If bank denies card, user must be able to update it
    public void setCreditCardNumber(String newCC) {
        this.creditCardNumber = newCC;
    }
}